package com.example.placementmanagementsystem.recruiter.recruiterdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecruiterRegisterResponseDto {
    private String name;
    private String email;
    private String phoneNumber;
    private Integer id;
}
