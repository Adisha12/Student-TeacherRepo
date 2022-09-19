package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class Exceptions {


    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<Object> studentNotFoundException(StudentNotFoundException exception) {
        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = StudentAlreadyPresentException.class)
    public ResponseEntity<Object> studentPresentException(StudentNotFoundException exception) {
        return new ResponseEntity<>("Student already registered!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = TeacherNotFoundException.class)
    public ResponseEntity<Object> teacherNotFoundException(TeacherNotFoundException exception) {
        return new ResponseEntity<>("Teacher not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = TeacherAlreadyPresentException.class)
    public ResponseEntity<Object> teacherPresentException(StudentNotFoundException exception) {
        return new ResponseEntity<>("Teacher already registered!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = SubjectNotFoundException.class)
    public ResponseEntity<Object> subjectNotFoundException(SubjectNotFoundException exception) {
        return new ResponseEntity<>("Subject not found", HttpStatus.NOT_FOUND);
    }
}