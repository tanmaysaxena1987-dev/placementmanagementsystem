package com.example.placementmanagementsystem.student.studentdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRegisterRequestDto {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private double cgpa;
}
