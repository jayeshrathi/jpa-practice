package com.example.jpa_practice.service;

import com.example.jpa_practice.entity.mysql.SchoolEntity;
import com.example.jpa_practice.entity.mysql.SchoolEntityPrimaryKey;
import com.example.jpa_practice.repository.mySql.SchoolRepositoryInterface;
import com.example.jpa_practice.repository.mySql.SchoolRepositoryInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    private final SchoolRepositoryInterface schoolRepository;

    public SchoolService(SchoolRepositoryInterface schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<SchoolEntity> getAllSchools() {
        return schoolRepository.findAll();
    }

    public Optional<SchoolEntity> getSchoolById(SchoolEntityPrimaryKey id) {
        return schoolRepository.findById(id);
    }

    public SchoolEntity createOrUpdateSchool(SchoolEntity entity) {
        return schoolRepository.save(entity);
    }

    public void deleteSchool(SchoolEntityPrimaryKey id) {
        schoolRepository.deleteById(id);
    }
}
