package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {

	@Autowired
    private StudentService studentService;
	
	
	@PostMapping(value= "/add")
	public ResponseEntity<String> addStudent(@RequestBody Student studentNewEntity){
        Student student=studentService.addStudent(studentNewEntity);
		return new ResponseEntity<>("Student successfully registered!", HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/update")
    public ResponseEntity<String> updateStudent(
            @RequestBody Student studentEntity) {
        Student student = studentService.updateStudent(studentEntity);
        return new ResponseEntity<>("Student successfully updated!", HttpStatus.OK);

    }
	
	
    @DeleteMapping(path = "/{id}/delete")
    public void deleteStudent(@PathVariable(name = "id") int id) {
        studentService.deleteStudent(id);
    }



    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Student>> getStudent(
            @PathVariable(name = "id") int id) {
        Optional<Student> student = studentService.getStudentByRollNo(id);
        return ResponseEntity.ok(student);
    }
}
