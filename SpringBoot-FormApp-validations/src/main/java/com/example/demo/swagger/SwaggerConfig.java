package com.example.demo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	public SwaggerConfig() {
		// TODO Auto-generated constructor stub
		System.out.println("****SwaggerConfig :: Contructor called");

	}

	@Bean
	public Docket docket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.resouces")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());

		return docket;

	}
	//http://localhost:9090/SpringBootFormApp/swagger-ui.html#

	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		Contact contact = new Contact("Charan", "www.cts.com", "charan.c@cts.com");

		ApiInfo info = new ApiInfo("SB Form App API", "This is for Testing", "1.0", "www.hacker.com", contact,
				"Apache Licence", "www.apache.org");
		return info;
	}

}
