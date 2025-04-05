package com.example.jpa_practice.entity.mysql;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class DepartmentEntityPrimaryKey implements Serializable {
    public String departmentName;
    public String departmentSchoolName;
}
