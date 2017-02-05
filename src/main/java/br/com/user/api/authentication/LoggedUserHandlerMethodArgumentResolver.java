package br.com.user.api.authentication;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import br.com.common.jwt.JwtFactory;

public class LoggedUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public Object resolveArgument(
			MethodParameter methodParameter,
			ModelAndViewContainer modelAndViewContainer, 
			NativeWebRequest nativeWebRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		
		String authorization = nativeWebRequest.getHeader("Authorization");

		if (StringUtils.isBlank(authorization)) {
			throw new IllegalArgumentException("Authorization header is required.");
		}
		
		Map<String, Object> values = JwtFactory
			.getVerifierInstance()
			.verify(authorization);
		
		if (values == null || values.isEmpty()) {
			throw new IllegalArgumentException("Authorization token is required.");
		}
		
		String userId = (String) values.get("userId");

		if (StringUtils.isBlank(userId)) {
			throw new IllegalArgumentException("UserId in auth token is required.");
		}

		return new LoggedUser(userId);
	}
	
	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.getParameterType().isAssignableFrom(LoggedUser.class);
	}
}
