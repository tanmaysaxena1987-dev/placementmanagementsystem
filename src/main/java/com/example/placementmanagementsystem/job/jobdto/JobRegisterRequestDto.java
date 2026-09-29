package com.example.placementmanagementsystem.job.jobdto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class JobRegisterRequestDto {
    private String designation;
    private String location;
    private double salary;
    private List<String> skills=new ArrayList<>();
    private double minCgpa;
}
