package com.example.placementmanagementsystem.company.companydtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyViewRequestResponseDto {
    private Integer id;
    private String name;
    private String email;
    private String location;
    private String phoneNumber;
}
