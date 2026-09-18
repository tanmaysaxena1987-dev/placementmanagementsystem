package com.example.placementmanagementsystem.controller;

import com.example.placementmanagementsystem.dto.studentdto.StudentRegisterRequestDto;
import com.example.placementmanagementsystem.dto.studentdto.StudentRegisterResponseDto;
import com.example.placementmanagementsystem.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
@Tag(name="Student Related Methods")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/register")
    @Operation(summary = "Register as Student")
    public ResponseEntity<StudentRegisterResponseDto> registerStudent(@Valid @RequestBody StudentRegisterRequestDto studentRegisterRequestDto) {
        return studentService.registerStudent(studentRegisterRequestDto);
    }
}
