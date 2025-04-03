package com.example.jpa_practice.service;

import com.example.jpa_practice.entity.StudentEntity;
import com.example.jpa_practice.repository.mySql.StudentRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentSaveService {


    private final  StudentRepositoryInterface studentRepository;


    @Transactional
    public StudentEntity save(StudentEntity studentEntity) {
        System.out.println("logging save");
            return studentRepository.save(studentEntity);
    }

    public StudentEntity get(long studentId) {
        return studentRepository.findById(studentId).get();
    }

    public StudentEntity update(StudentEntity studentEntity) {

        return studentRepository.findById(studentEntity.getStudentIdCard())
                .map(existingUser -> {
                    StudentEntity studentEntity1 = studentRepository.save(studentEntity);
                    return studentEntity1;
                })
                .orElseGet(() -> null);
    }

    public List<StudentEntity> listOfStudents(String name) {
        List<StudentEntity> studentEntity;
        if (name==null){
            studentEntity = studentRepository.findAll();
        }
        else studentEntity = studentRepository.findByName( name);

        return studentEntity;
    }
}
