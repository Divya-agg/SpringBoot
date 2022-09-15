package com.example.demo.controllers;

import com.example.demo.services.TasksService;
import com.example.demo.services.TasksServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TasksResponse;
import com.example.demo.models.Task;

@RestController
@RequestMapping("/tasks")
public class TasksController {
	@Autowired
	private TasksService tasksService;

//	@Autowired
//	public TasksController() {
//		this.tasksService=new TasksServiceImpl();
//	}

	@GetMapping("/all")
	public TasksResponse getAllTasks() {
		var tasks=tasksService.getAllTasks();
        System.out.println(tasks);
		return new TasksResponse(tasks.size(),tasks);
	}
	
	@GetMapping("/{id}")
	public String getTaskById(@PathVariable("id") String id) {
		return "TODO : Task no : " + id;
	}
}
