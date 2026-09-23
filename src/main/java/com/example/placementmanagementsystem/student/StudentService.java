package com.example.placementmanagementsystem.student;

import com.example.placementmanagementsystem.common.exception.UserWithEmailAlreadyExists;
import com.example.placementmanagementsystem.common.repo.UserRepo;
import com.example.placementmanagementsystem.student.dtos.StudentRegisterRequestDto;
import com.example.placementmanagementsystem.student.dtos.StudentRegisterResponseDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentMapper mapper;
    @Autowired
    private UserRepo userRepo
    @Autowired
    private StudentMapper studentMapper;
    @Transactional
    public ResponseEntity<StudentRegisterResponseDto> registerStudent(@Valid StudentRegisterRequestDto studentRegisterRequestDto) {

    }
}
