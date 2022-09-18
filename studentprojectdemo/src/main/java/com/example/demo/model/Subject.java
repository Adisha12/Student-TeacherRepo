package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class Subject {

    @Id
    @Column(nullable = false)
    private int id;

    @Column(nullable = false, length=99)
    private String name;
}
