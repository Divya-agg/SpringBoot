package com.example.demo;

import com.example.demo.services.TasksService;
import com.example.demo.services.TasksServiceImpl;
import com.example.demo.services.TasksServiceTestImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Api2Application {
	private static boolean isTestingEnv=false;

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
			return new TasksServiceTestImpl();
		}
		else {
			System.out.println("______________Production Environment Real services____________ ");
			return new TasksServiceImpl();
		}
	}
}
