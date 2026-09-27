package com.example.placementmanagementsystem.company.companydtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRegisterRequestDto {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String location;
}
