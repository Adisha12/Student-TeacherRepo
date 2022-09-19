package com.example.demo.service;
import com.example.demo.exception.*;

import com.example.demo.model.Teacher;
import com.example.demo.repository.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@Slf4j
public class TeacherService {


    @Autowired
    SubjectRepository subjectrepo;

    @Autowired
    TeacherRepository teacherrepo;


    public Teacher addTeacher(Teacher teacherEntity) {
        if (teacherrepo.findById(teacherEntity.getId()).isPresent()) {

            log.error("Teacher already exists");
            throw new TeacherAlreadyPresentException();
        }

        else if (subjectrepo.findById(teacherEntity.getSubject_id().getId()).isPresent()) {
            log.error("Subject id doesn't exists");
            throw new SubjectNotFoundException();
        }
        else
            return teacherrepo.save(teacherEntity);

    }

    public Teacher updateTeacher(Teacher teacherEntity) {
        return teacherrepo.save(teacherEntity);

    }

    public void deleteTeacher(int rollno) {
        if (teacherrepo.findById(rollno).isPresent())
            teacherrepo.deleteById(rollno);

        else {
            log.error("Student not found");
            throw new TeacherNotFoundException();
        }
    }


    public Optional<Teacher> getTeacherById(int id) {
        return teacherrepo.findById(id);
    }

}
