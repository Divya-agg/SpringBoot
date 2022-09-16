package com.example.demo.controllers;

import com.example.demo.dto.ErrorResponse;
import com.example.demo.dto.SuccessResponse;
import com.example.demo.services.TasksService;
import com.example.demo.services.TasksServiceImpl;

import java.util.List;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.TasksResponse;
import com.example.demo.models.Task;

@RestController
@RequestMapping("/tasks")
public class TasksController {
	@Autowired
	private TasksService tasksService;

	@GetMapping("/all")
	public ResponseEntity<TasksResponse> getAllTasks() {
		var tasks=tasksService.getAllTasks();
        System.out.println(tasks);
		return ResponseEntity.ok(new TasksResponse(tasks.size(),tasks));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable("id") Integer id) {
		var task=tasksService.getTaskById(id);
		return ResponseEntity.ok(task);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<SuccessResponse> deleteTask(@PathVariable("id") Integer id){
		tasksService.deleteTask(id);
		return ResponseEntity.accepted().body(new SuccessResponse("Task no "+id+" deleted"));
	}

	@PostMapping("")
	public ResponseEntity<SuccessResponse> createTask(@RequestBody Task task){
		tasksService.createTask(task);
		return ResponseEntity.accepted().body(new SuccessResponse("Task created : " + task));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<SuccessResponse> updateTask(@PathVariable("id") Integer id,@RequestBody Task task){
		tasksService.updateTask(id,task);
		return ResponseEntity.accepted().body(new SuccessResponse("Update Task no : " + id +" with task ="+task));
	}

	@ExceptionHandler(TasksService.TaskNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex){
		return new ResponseEntity<>(
					new ErrorResponse(ex.getMessage()),
					HttpStatus.NOT_FOUND
		);
	}

}
