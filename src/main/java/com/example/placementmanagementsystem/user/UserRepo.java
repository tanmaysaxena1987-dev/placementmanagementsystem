package com.example.placementmanagementsystem.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    boolean existsByEmail(String email);

    Users findByEmail(String username);
}
