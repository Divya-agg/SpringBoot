package com.example.demo;

import com.example.demo.services.TasksH2Impl;
import com.example.demo.services.TasksService;
import com.example.demo.services.TasksServiceImpl;
import com.example.demo.services.TasksServiceTestImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Documentation;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
public class Api2Application {
	private static boolean isTestingEnv=true;

	public static void main(String[] args) {
		if(args.length>0){
			if(args[0].equals("test"))
				isTestingEnv=true;
		}
		SpringApplication.run(Api2Application.class, args);
	}
	@Bean
	public TasksService tasksService(){
		if(isTestingEnv) {
			System.out.println("*********Testing Environment mock services************ ");
			return new TasksH2Impl();
		}
		else {
			System.out.println("______________Production Environment Real services____________ ");
			return new TasksServiceImpl();
		}
	}
	@Bean
	public Docket taskAPI(){
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis((RequestHandlerSelectors.basePackage("com.example.demo"))).build();
	}
}
