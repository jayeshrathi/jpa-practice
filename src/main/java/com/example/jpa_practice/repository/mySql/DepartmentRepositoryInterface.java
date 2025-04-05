package com.example.jpa_practice.repository.mySql;

import com.example.jpa_practice.entity.mysql.DepartmentEntity;
import com.example.jpa_practice.entity.mysql.DepartmentEntityPrimaryKey;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepositoryInterface extends JpaRepository<DepartmentEntity,DepartmentEntityPrimaryKey> {
}
