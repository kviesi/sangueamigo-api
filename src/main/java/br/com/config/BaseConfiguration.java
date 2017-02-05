package br.com.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.common.json.JsonConverter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableCircuitBreaker
@EnableSwagger2
@EnableTransactionManagement
@Configuration
public class BaseConfiguration {
	
	@Bean
	JsonConverter json() {
		return new JsonConverter(new ObjectMapper());
	}

	@Bean
	Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("SangueAmigo")
				.apiInfo(apiInfo())
				.select()
				.paths(regex("/v1.0/hemocentro*"))
				.paths(regex("/v1.0/donation*"))
				.paths(regex("/v1.0/user*"))
				.build();
	}

	ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("SangueAmigo API")
				.description("SangueAmigo API")
				.contact("Kaio Viesi")
				.version("2.0")
				.build();
	}

}
