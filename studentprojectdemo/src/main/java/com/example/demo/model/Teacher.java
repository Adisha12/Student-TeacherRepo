package com.example.demo.model;

import javax.persistence.*;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Student subject_id;
}
