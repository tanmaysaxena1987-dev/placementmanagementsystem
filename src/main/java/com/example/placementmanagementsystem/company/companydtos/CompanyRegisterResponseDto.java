package com.example.placementmanagementsystem.company.companydtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRegisterResponseDto {
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String location;
}
