package com.example.demo.controller;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @PostMapping(value= "/addteacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacherNewEntity){
        Teacher teacher=teacherService.addTeacher(teacherNewEntity);
        return new ResponseEntity<>("Teacher successfully registered!", HttpStatus.CREATED);
    }

    @PutMapping(path = "/updateteacher")
    public ResponseEntity<String> updateTeacher(
            @RequestBody Teacher teacherEntity) {
        Teacher teacher = teacherService.updateTeacher(teacherEntity);
        return new ResponseEntity<>("Teacher successfully updated!", HttpStatus.OK);

    }


    @DeleteMapping(path = "/{id}/deleteteacher")
    public void deleteTeacher(@PathVariable(name = "id") int id) {
        teacherService.deleteTeacher(id);
    }



    @GetMapping(path = "/teacher/{id}")
    public ResponseEntity<Optional<Teacher>> getTeacher(
            @PathVariable(name = "id") int id) {
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        return ResponseEntity.ok(teacher);
    }

}
