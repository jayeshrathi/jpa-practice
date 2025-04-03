package com.example.jpa_practice.controller;


import com.example.jpa_practice.entity.StudentDTO;
import com.example.jpa_practice.service.StudentSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {


    private final StudentSaveService studentSaveService;

    @PostMapping("/save")
    public StudentDTO saveStudent(
            @RequestBody StudentDTO studentDTO){
        return studentSaveService.save(studentDTO);
    }
    @GetMapping("/studentDetails/{id}")
    public StudentDTO saveStudent(
            @PathVariable(name = "id") int studentId ){
        return studentSaveService.get(studentId);
    }

    @PutMapping("/update")
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO){
        return studentSaveService.update(studentDTO);
    }

    @GetMapping("/list")
    public ResponseEntity<List<StudentDTO>> studentList(
            @RequestParam(required = false) String name){
        return ResponseEntity.ok().body(studentSaveService.listOfStudents(name));
    }
}
