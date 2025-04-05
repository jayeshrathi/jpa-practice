package com.example.jpa_practice.entity.mysql;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "school")
@Data
@IdClass(SchoolEntityPrimaryKey.class)
public class SchoolEntity {

    @Id
    public String schoolName;
    @Id
    public String address;
    public String schoolFees;
}
