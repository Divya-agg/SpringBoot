package com.example.demo.services;

import com.example.demo.models.Task;
import com.example.demo.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class TasksH2Impl implements TasksService{

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        List<Task> list=new ArrayList<>();
        taskRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Task getTaskById(int id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(int id, Task task) {
        Task existingTask=taskRepository.findById(id).get();
        existingTask.setName(task.getName());
        existingTask.setCompleted(task.isCompleted());
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
