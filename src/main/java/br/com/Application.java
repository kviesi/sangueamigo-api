package br.com;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.common.json.JsonConverter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCircuitBreaker
@EnableSwagger2
@EnableAutoConfiguration
@EnableTransactionManagement
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

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