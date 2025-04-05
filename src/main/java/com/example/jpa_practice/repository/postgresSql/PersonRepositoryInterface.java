package com.example.jpa_practice.repository.postgresSql;


import com.example.jpa_practice.entity.mysql.StudentEntity;
import com.example.jpa_practice.entity.postgresSql.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepositoryInterface extends JpaRepository<PersonEntity, Long> {

}
