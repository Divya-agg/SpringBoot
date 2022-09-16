package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Task;

@Service
public interface TasksService {

	List<Task> getAllTasks();
	Task getTaskById(int id);
	Task createTask(Task task);
	Task updateTask(int id,Task task);
	void deleteTask(int id);

	class TaskNotFoundException extends IllegalArgumentException{
		public TaskNotFoundException(int id){
			super("could not find task "+id);
		}
	}
	
}
