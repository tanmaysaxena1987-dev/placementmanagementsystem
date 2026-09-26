package com.example.placementmanagementsystem.student.studentdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRegisterResponseDto {
    private Integer id;
    private String name;
    private String email;
    private String  phoneNumber;
    private double cgpa;
}
