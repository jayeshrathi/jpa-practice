package com.example.jpa_practice.entity.mysql;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "studentUniqueNumber"
)
public class StudentDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String studentUniqueNumber;
    public String studentColour;
    public String studentHeight;
    public String studentWeight;

    //    when working with mapped by use JsonManageReference JsonBackReference or DTO or JsonIgnore OR @JsonIdentityInfo to avoid recusive response
    @OneToOne(mappedBy = "studentDescription")
    public StudentEntity student;

}
