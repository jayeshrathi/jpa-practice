package com.example.jpa_practice.service;

import com.example.jpa_practice.entity.StudentDTO;
import com.example.jpa_practice.repository.mySql.StudentRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentSaveService {


    private final  StudentRepositoryInterface studentRepository;


    @Transactional
    public StudentDTO save(StudentDTO studentDTO) {
        System.out.println("logging save");
            return studentRepository.save(studentDTO);
    }

    public StudentDTO get(long studentId) {
        return studentRepository.findById(studentId).get();
    }

    public StudentDTO update(StudentDTO studentDTO) {

        return studentRepository.findById(studentDTO.getStudentIdCard())
                .map(existingUser -> {
                    StudentDTO studentDTO1 = studentRepository.save(studentDTO);
                    return studentDTO1;
                })
                .orElseGet(() -> null);
    }

    public List<StudentDTO> listOfStudents(String name) {
        List<StudentDTO> studentDTO ;
        if (name==null){
            studentDTO= studentRepository.findAll();
        }
        else studentDTO= studentRepository.findByName( name);

        return studentDTO;
    }
}
