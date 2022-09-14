package com.example.demo.models;

import java.util.Date;

import lombok.Data;

@Data
public class Task {

	public Task(int id, String name, boolean completed, Date dueBy) {
		super();
		this.id = id;
		this.name = name;
		this.completed = completed;
		this.dueBy = dueBy;
	}
	private int id;
	private String name;
	private boolean completed;
	private Date dueBy;
}
