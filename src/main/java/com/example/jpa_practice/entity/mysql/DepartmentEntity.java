package com.example.jpa_practice.entity.mysql;

import jakarta.persistence.*;

@Entity
@Table(name = "deparment")

public class DepartmentEntity {

    @EmbeddedId
    public  DepartmentEntityPrimaryKey departmentEntityPrimaryKey;

    @Column(name = "departmnet_HOD")
    public String departmentHOD;

}
