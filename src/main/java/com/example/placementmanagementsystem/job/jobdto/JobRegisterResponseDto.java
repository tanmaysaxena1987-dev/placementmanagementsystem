package com.example.placementmanagementsystem.job.jobdto;

import com.example.placementmanagementsystem.job.JobType;
import com.example.placementmanagementsystem.student.StudentDepartment;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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
    private String company_name;
    private JobType jobType;
    private List<StudentDepartment>eligibleDepartment=new ArrayList<>();
    private LocalDateTime graduationDate;
    private String description;
}
