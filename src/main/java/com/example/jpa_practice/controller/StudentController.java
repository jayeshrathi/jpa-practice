package com.example.jpa_practice.controller;


import com.example.jpa_practice.entity.StudentEntity;
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
    public StudentEntity saveStudent(
            @RequestBody StudentEntity studentEntity){
        return studentSaveService.save(studentEntity);
    }
    @GetMapping("/studentDetails/{id}")
    public StudentEntity saveStudent(
            @PathVariable(name = "id") int studentId ){
        return studentSaveService.get(studentId);
    }

    @PutMapping("/update")
    public StudentEntity updateStudent(@RequestBody StudentEntity studentEntity){
        return studentSaveService.update(studentEntity);
    }

    @GetMapping("/list")
    public ResponseEntity<List<StudentEntity>> studentList(
            @RequestParam(required = false) String name){
        return ResponseEntity.ok().body(studentSaveService.listOfStudents(name));
    }
}
