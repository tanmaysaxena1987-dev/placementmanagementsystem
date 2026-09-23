package com.example.placementmanagementsystem.student;

import com.example.placementmanagementsystem.student.dtos.StudentRegisterRequestDto;
import com.example.placementmanagementsystem.student.dtos.StudentRegisterResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    public ResponseEntity<StudentRegisterResponseDto> registerStudent(@Valid @RequestBody StudentRegisterRequestDto studentRegisterRequestDto) {
        return studentService.registerStudent(studentRegisterRequestDto);
    }
}
