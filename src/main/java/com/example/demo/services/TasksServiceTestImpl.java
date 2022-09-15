package com.example.demo.services;

import com.example.demo.models.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class TasksServiceTestImpl implements TasksService{

	private final ArrayList<Task> taskList;

	public TasksServiceTestImpl() {
		taskList=new ArrayList<>();
		taskList.add(new Task(1,"Test task 1",false,new Date()));
		taskList.add(new Task(2,"Test task 2",false,new Date()));
		taskList.add(new Task(3,"Test task 3",false,new Date()));
	}

	@Override
	public List<Task> getAllTasks() {
		return taskList;
	}

	@Override
	public Task getTaskById(int id) {
		AtomicReference<Task> task=null;
		taskList.forEach(t->{
			if(t.getId()==id){
				task.set(t);}
		});
		if(task.get()==null){
			throw new TaskNotFoundException(id);
		}
		return task.get();
	}

	@Override
	public Task createTask(Task task) {
		//TODO : Generate new unique id
		Task newTask=new Task(task.getId(),task.getName(),task.isCompleted(),task.getDueBy());
		taskList.add(newTask);
		return task;
	}

	@Override
	public Task updateTask(int id, Task task) {
		Task existingTask=getTaskById(id);

		if(task.getName()!=null){existingTask.setName(task.getName());}
		if(task.isCompleted()){existingTask.setCompleted(task.isCompleted());}
		if(task.getDueBy()!=null){existingTask.setDueBy(task.getDueBy());}

		return existingTask;
	}

	@Override
	public void deleteTask(int id) {
		taskList.remove(getTaskById(id));
	}

}
