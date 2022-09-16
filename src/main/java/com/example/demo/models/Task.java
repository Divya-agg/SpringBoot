package com.example.demo.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "task")
@NoArgsConstructor
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="taskid")
	private int id;
	@Column(name="name", updatable = true, nullable = false)
	private String name;
	@Column(name = "completed", updatable = true, nullable = false)
	private boolean completed;
	@Column(name = "dueby", updatable = true, nullable = true)
	private Date dueBy;
}
