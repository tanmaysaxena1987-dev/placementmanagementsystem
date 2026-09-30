package com.example.placementmanagementsystem.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    Student getByUserEmail(String name);
    Student findByUserId(Integer id);
}
