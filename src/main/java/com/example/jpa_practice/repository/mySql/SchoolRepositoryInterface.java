package com.example.jpa_practice.repository.mySql;

import com.example.jpa_practice.entity.mysql.SchoolEntity;
import com.example.jpa_practice.entity.mysql.SchoolEntityPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepositoryInterface extends JpaRepository<SchoolEntity, SchoolEntityPrimaryKey> {
}
