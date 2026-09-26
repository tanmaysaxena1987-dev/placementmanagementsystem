package com.example.placementmanagementsystem.student;

import com.example.placementmanagementsystem.student.studentdto.StudentRegisterRequestDto;
import com.example.placementmanagementsystem.student.studentdto.StudentRegisterResponseDto;
import com.example.placementmanagementsystem.student.studentdto.StudentViewRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
@Tag(name = "Student Related Operations")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Operation(summary = "Register As A Student")
    @PostMapping("/register")
    public ResponseEntity<StudentRegisterResponseDto> registerStudent(@Valid @RequestBody StudentRegisterRequestDto studentRegisterRequestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentService.registerStudent(studentRegisterRequestDto));
    }
    @Operation(summary = "view student profile")
    @GetMapping("/viewprofile")
    public ResponseEntity<StudentViewRequestDto> viewStudent(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentService.viewStudent());
    }
}
