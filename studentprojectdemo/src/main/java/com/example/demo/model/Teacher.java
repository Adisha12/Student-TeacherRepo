package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="TeacherEntity")
@Getter
@Setter
public class Teacher {

    @Id
    @Column(nullable = false)
    private int id;

    @Column(nullable = false, length=99)
    private String first_name;

    @Column(nullable = false, length=99)
    private String last_name;

    @Column(length=1)
    private char gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject subject_id;
}
