package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;


@Entity(name="StudentEntity")
@Getter
@Setter
public class Student {

	@Id
	@Column(nullable = false)
	private int id;

	@Column(nullable = false, length=99)
	private String first_name;

	@Column(nullable = false, length=99)
	private String last_name;

	@Column(length=1)
	private char gender;

	private int classno;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "class_teacher_id")
	private Teacher class_teacher_id;
	
}
