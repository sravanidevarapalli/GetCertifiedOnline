package com.GetCertifiedOnline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableSwagger2
@SpringBootApplication
public class GetCertifiedOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetCertifiedOnlineApplication.class, args);
	}
	@Bean
	public Docket surveyAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.GetCertifiedOnline"))
				.build()
				.apiInfo(apiDetails());
				
	}
	public ApiInfo apiDetails() {
		return new ApiInfo(
				"Get Certified Online",
				"For booking Certification and Course",
				"TM",
				"",
				"",
				"Api License",
				"http://localhost:9200/api");
	}

}
