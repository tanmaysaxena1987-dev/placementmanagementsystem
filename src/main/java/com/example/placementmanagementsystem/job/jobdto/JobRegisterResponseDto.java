package com.example.placementmanagementsystem.job.jobdto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class JobRegisterResponseDto {
    private Integer id;
    private String designation;
    private String location;
    private double salary;
    private List<String> skills=new ArrayList<>();
    private Integer recruiter_id;
    private String recruiter_email;
    private String recruiter_name;
    private String company_name;
}
