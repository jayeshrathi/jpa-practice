package com.example.jpa_practice.entity.postgresSql;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "custom_sequence_generator")
    @SequenceGenerator(name = "custom_sequence_generator", sequenceName = "database_sequence_name_my_sequence",allocationSize = 10)
    private Long nationalCard;
    private String name;
    private String surname;
    private String dob;
    private int age;
    private long mobile;
}
