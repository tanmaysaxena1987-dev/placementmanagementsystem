package com.example.placementmanagementsystem.student.dtos;

import com.example.placementmanagementsystem.student.StudentDepartment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRegisterRequestDto {
    private String email;
    private String password;
    private String name;
    private String phoneNumber;
    private double cgpa;
    private int semester;
    private StudentDepartment studentDepartment;
    private String rollNo;

}
