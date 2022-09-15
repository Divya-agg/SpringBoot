package com.example.demo.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
	private int id;
	private String name;
	private boolean completed;
	private Date dueBy;
}
