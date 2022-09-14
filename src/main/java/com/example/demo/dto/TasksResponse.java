package com.example.demo.dto;

import java.util.List;
import com.example.demo.models.Task;

import lombok.Data;

@Data
public class TasksResponse {

	private int taskCount;
	private List<Task> tasks;
	
	public TasksResponse(int taskCount, List<Task> tasks) {
		this.taskCount = taskCount;
		this.tasks = tasks;
	}
	

}
