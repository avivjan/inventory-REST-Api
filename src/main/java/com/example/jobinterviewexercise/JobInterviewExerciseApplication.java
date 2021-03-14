package com.example.jobinterviewexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.w3c.dom.DocumentType;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.swing.text.Document;
import java.util.Collections;

@SpringBootApplication
@EnableAsync
@EnableSwagger2
public class JobInterviewExerciseApplication
{
	public static void main(String[] args)
	{

		SpringApplication.run(JobInterviewExerciseApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.jobinterviewexercise"))
				.build()
				.apiInfo(apiDetalis());
	}

	private ApiInfo apiDetalis()
	{
		return new ApiInfo(
				"Inventory app docs",
				"This is a rest api for managing inventory of items",
				"1.0.0",
				"Free to use",
				new springfox.documentation.service.Contact("Aviv Jan", "", "Avivjan2000@gmail.com"),
				"API License",
				"",
				Collections.emptyList());
	}
}
