package com.example.placementmanagementsystem.repo;

import com.example.placementmanagementsystem.model.Users;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);

    boolean existsByEmail(@Email @NotBlank String email);
}
