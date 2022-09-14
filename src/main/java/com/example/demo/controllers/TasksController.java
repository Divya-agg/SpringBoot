package com.example.demo.controllers;

import com.example.demo.services.TasksService;
import com.example.demo.services.TasksServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TasksResponse;

@RestController
@RequestMapping("/tasks")
public class TasksController {
	private final TasksService tasksService;
	
	public TasksController() {
		this.tasksService=new TasksServiceImpl();
	}

	@GetMapping("")
	public TasksResponse getAllTasks() {
		var tasks=tasksService.getAllTasks();
//		//System.out.println(tasks);
//		TasksResponse tr=new TasksResponse(tasks.size(), tasks);
//		System.out.println(tr);
		return new TasksResponse(tasks.size(),tasks);
	}
	
	@GetMapping("/{id}")
	public String getTaskById(@PathVariable("id") String id) {
		return "TODO : Task no : " + id;
	}
}
