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
	private String second_name;

	@Column(length=1)
	private char gender;

	private int classno;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Teacher class_teacher_id;
	
}
