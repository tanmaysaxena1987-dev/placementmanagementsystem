package com.example.placementmanagementsystem.student;

import com.example.placementmanagementsystem.student.dtos.StudentRegisterRequestDto;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

}
