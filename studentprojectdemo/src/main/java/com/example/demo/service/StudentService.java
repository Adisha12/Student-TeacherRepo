package com.example.demo.service;

import com.example.demo.exception.StudentAlreadyPresentException;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.exception.TeacherNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.StudentRepository;

import java.util.Optional;

@Service
@Slf4j
public class StudentService {

	@Autowired
	StudentRepository studentrepo;

	@Autowired
	TeacherRepository teacherrepo;


	public Student addStudent(Student studentEntity) {
		if (studentrepo.findById(studentEntity.getId()).isPresent()) {
			log.error("Student already exists");
			throw new StudentAlreadyPresentException();
		} else if (teacherrepo.findById(studentEntity.getClass_teacher_id().getId()).isPresent())
		{
			return studentrepo.save(studentEntity);
		} else
			log.error("Teacher id doesn't exists");
		    throw new TeacherNotFoundException();

	}

	public Student updateStudent(Student studentEntity) {
		return studentrepo.save(studentEntity);

	}

	public void deleteStudent(int rollno) {
		if (studentrepo.findById(rollno).isPresent())
			studentrepo.deleteById(rollno);

		else {
			log.error("Student not found");

			throw new StudentNotFoundException();
		}
	}


	public Optional<Student> getStudentByRollNo(int rollno) {
		return studentrepo.findById(rollno);
	}

}

