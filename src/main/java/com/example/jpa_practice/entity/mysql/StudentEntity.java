package com.example.jpa_practice.entity.mysql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "student")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  studentIdCard;
    private String name;
    private Integer rollNumber;
    private String schoolName;

//JoinColumn is compulsory in case SchoolEntity contains the combined  primary key
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name= "school_schoolName",referencedColumnName = "schoolName"),
            @JoinColumn(name = "school_address",referencedColumnName = "address")})
    private SchoolEntity school;

//  If join column annotation not given it chooses primary key  of StudentDescription Table as  referencedColumnName and  name as fieldName_id(studentDescription_id)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "table_column_name_inside_student_table",referencedColumnName = "studentUniqueNumber")
    private StudentDescription studentDescription;
}