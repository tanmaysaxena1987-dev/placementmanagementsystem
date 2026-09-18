package com.example.placementmanagementsystem.dto.studentdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRegisterResponseDto {
    private Long id;
    private String  username;
    private String name;
    private int semester;
    private String department;
    private String role;
    private String email;
    private Double cgpa;
}
