package com.example.jpa_practice.controller;

import com.example.jpa_practice.entity.mysql.DepartmentEntity;
import com.example.jpa_practice.entity.mysql.DepartmentEntityPrimaryKey;
import com.example.jpa_practice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping
    public DepartmentEntity create(@RequestBody DepartmentEntity department) {
        return service.save(department);
    }

    @GetMapping
    public List<DepartmentEntity> getAll() {
        return service.findAll();
    }

    @GetMapping("/find")
    public Optional<DepartmentEntity> getOne(@RequestParam String departmentName,
                                             @RequestParam String departmentSchoolName) {
        DepartmentEntityPrimaryKey key = new DepartmentEntityPrimaryKey();
        key.setDepartmentName(departmentName);
        key.setDepartmentSchoolName(departmentSchoolName);
        return service.findById(key);
    }

    @DeleteMapping
    public void delete(@RequestParam String departmentName,
                       @RequestParam String departmentSchoolName) {
        DepartmentEntityPrimaryKey key = new DepartmentEntityPrimaryKey();
        key.setDepartmentName(departmentName);
        key.setDepartmentSchoolName(departmentSchoolName);
        service.deleteById(key);
    }

    @PutMapping
    public DepartmentEntity update(@RequestBody DepartmentEntity department) {
        return service.save(department);
    }
}
