package com.example.placementmanagementsystem.recruiter;

import com.example.placementmanagementsystem.recruiter.recruiterdto.RecruiterRegisterResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepo extends JpaRepository<Recruiter, Integer> {
    Recruiter findByEmail(String email);
}
