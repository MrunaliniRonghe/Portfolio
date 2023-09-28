package com.attempt3.apis;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
*/


@SpringBootApplication
//@EnableSwagger2
public class IDemo3Application {

	public static void main(String[] args) {
		SpringApplication.run(IDemo3Application.class, args);
		System.out.println("Application Working");
	}
	
	/*@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/*"))
				.apis(RequestHandlerSelectors.basePackage("com.attempt3.apis"))
				.build()
				.apiInfo(apiCustomData());
	}

	private ApiInfo apiCustomData(){
		return new ApiInfo(
				"Transaction Management API Application",
				"Transaction Management Documentation",
				"1.0",
				"Bank Service Terms",
				new Contact("User 1", "https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api",
						"user@bank.com"),
				"Transaction License",
				"https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api",
				Collections.emptyList()
		);
	}*/
}
