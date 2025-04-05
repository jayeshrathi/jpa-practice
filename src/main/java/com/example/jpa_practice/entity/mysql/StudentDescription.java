package com.example.jpa_practice.entity.mysql;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StudentDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String studentUniqueNumber;
    public String studentColour;
    public String studentHeight;
    public String studentWeight;


}
