package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class StudentException {


    @ExceptionHandler(value = StudentNotFoundException.class)

    public ResponseEntity<Object> notFoundException(StudentNotFoundException exception) {
        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = StudentAlreadyPresentException.class)
    public ResponseEntity<Object> studentPresentException(StudentNotFoundException exception) {
        return new ResponseEntity<>("Student already registered!", HttpStatus.BAD_REQUEST);


    }
}