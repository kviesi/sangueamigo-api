package br.com.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import br.com.user.api.authentication.LoggedUserHandlerMethodArgumentResolver;

@EnableWebMvc
@Configuration
public class MVCConfiguration extends WebMvcConfigurationSupport {
	
	@Override
	protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new LoggedUserHandlerMethodArgumentResolver());
	}

}
