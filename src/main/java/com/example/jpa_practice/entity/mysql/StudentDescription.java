package com.example.jpa_practice.entity.mysql;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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

    //    when working with mapped by use JsonManageReference JsonBackReference or DTO or JsonIgnore OR @JsonIdentityInfo to avoid recusive response
    @JsonBackReference
    @OneToOne(mappedBy = "studentDescription")
    public StudentEntity student;

}
