package com.example.placementmanagementsystem.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Integer> {
    Company findByUserEmail(String email);
    Company findByUserId(Integer id);
}
