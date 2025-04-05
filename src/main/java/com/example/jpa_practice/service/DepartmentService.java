package com.example.jpa_practice.service;

import com.example.jpa_practice.entity.mysql.DepartmentEntity;
import com.example.jpa_practice.entity.mysql.DepartmentEntityPrimaryKey;
import com.example.jpa_practice.repository.mySql.DepartmentRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepositoryInterface repository;

    public DepartmentEntity save(DepartmentEntity department) {
        return repository.save(department);
    }

    public Optional<DepartmentEntity> findById(DepartmentEntityPrimaryKey id) {
        return repository.findById(id);
    }

    public List<DepartmentEntity> findAll() {
        return repository.findAll();
    }

    public void deleteById(DepartmentEntityPrimaryKey id) {
        repository.deleteById(id);
    }
}
