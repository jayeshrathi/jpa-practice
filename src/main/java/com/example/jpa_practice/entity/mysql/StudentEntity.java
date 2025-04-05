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

//    private SchoolEntity school;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "table_column_name_inside_student_table",referencedColumnName = "studentUniqueNumber")
    private StudentDescription studentDescription;
}