package com.example.demo.dto;

import java.util.List;
import com.example.demo.models.Task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TasksResponse {

	private int taskCount;
	private List<Task> tasks;

}
