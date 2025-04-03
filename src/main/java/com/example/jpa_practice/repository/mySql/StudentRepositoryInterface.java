package com.example.jpa_practice.repository.mySql;


import com.example.jpa_practice.entity.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepositoryInterface  extends JpaRepository<StudentDTO, Long> {

    List<StudentDTO> findByName(String name);
}
