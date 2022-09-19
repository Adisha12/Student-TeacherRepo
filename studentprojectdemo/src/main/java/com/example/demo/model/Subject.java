package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name="SubjectEntity")
@Getter
@Setter
public class Subject {

    @Id
    @Column(nullable = false)
    private int id;

    @Column(nullable = false, length=99)
    private String name;
}
