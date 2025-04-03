package com.example.jpa_practice.service;

import com.example.jpa_practice.dto.StudentDTO;
import com.example.jpa_practice.repository.StudentRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentSaveService {

    private final StudentRepositoryInterface studentRepository;


    public StudentDTO save(StudentDTO studentDTO) {
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
