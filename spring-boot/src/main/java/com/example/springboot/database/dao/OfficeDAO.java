package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfficeDAO extends JpaRepository<Office, Long> {

    @Query("SELECT o FROM Office o ORDER BY o.city")
    List<Office> findAllOrderedByName();

    Office findById(Integer id);

}
