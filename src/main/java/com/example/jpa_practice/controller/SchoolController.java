package com.example.jpa_practice.controller;

import com.example.jpa_practice.entity.mysql.SchoolEntity;
import com.example.jpa_practice.entity.mysql.SchoolEntityPrimaryKey;
import com.example.jpa_practice.service.SchoolService;
import com.example.jpa_practice.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public List<SchoolEntity> getAll() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/find")
    public ResponseEntity<SchoolEntity> getOne(@RequestParam String schoolName, @RequestParam String address) {
        SchoolEntityPrimaryKey key = new SchoolEntityPrimaryKey();
        key.setSchoolName(schoolName);
        key.setAddress(address);

        return schoolService.getSchoolById(key)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SchoolEntity create(@RequestBody SchoolEntity entity) {
        return schoolService.createOrUpdateSchool(entity);
    }

    @PutMapping
    public SchoolEntity update(@RequestBody SchoolEntity entity) {
        return schoolService.createOrUpdateSchool(entity);
    }

    @DeleteMapping
    public void delete(@RequestParam String schoolName, @RequestParam String address) {
        SchoolEntityPrimaryKey key = new SchoolEntityPrimaryKey();
        key.setSchoolName(schoolName);
        key.setAddress(address);
        schoolService.deleteSchool(key);
    }
}
