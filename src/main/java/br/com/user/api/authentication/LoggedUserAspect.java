package br.com.user.api.authentication;

import java.lang.reflect.Field;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.WebRequest;

import br.com.common.jwt.JwtFactory;

@Aspect
@Component
public class LoggedUserAspect {
	
	private static final String AUTHENTICATION_HEADER = "X-Custom-Auth";
	
	@Autowired
	private WebRequest webRequest;

	@Around("execution(* LoggedUserProvider.getLoggedUser())")
	public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		LoggedUserProvider loggedUserProvider = (LoggedUserProvider) proceedingJoinPoint.getTarget();

		if (!loggedUserProvider.hasLoggedUser()) {

			String token = webRequest.getHeader(AUTHENTICATION_HEADER);
	
			if (!StringUtils.hasText(token)) {
				throw new RuntimeException("token required."); // pensar melhor
			}
	
			Map<String, Object> claims = JwtFactory.getVerifierInstance().verify(token);
	
			LoggedUser loggedUser = new LoggedUser(
				(Long) claims.get("userId"),
				(String) claims.get("userEmail"),
				(String) claims.get("userName"));
	
			Field field = ReflectionUtils.findField(LoggedUserProvider.class, "loggedUser");
			field.setAccessible(true);
			ReflectionUtils.setField(field, loggedUserProvider, loggedUser);
		
		}

		proceedingJoinPoint.proceed();
	}

}
