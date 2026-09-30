package com.example.placementmanagementsystem.job.jobdto;

import com.example.placementmanagementsystem.job.JobType;
import com.example.placementmanagementsystem.student.StudentDepartment;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumeratedValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class JobRegisterRequestDto {
    @NotBlank
    private String designation;
    @NotBlank
    private String location;
    @NotNull
    private double salary;
    private String description;
    private List<String> skills=new ArrayList<>();
    private double minCgpa;
    @NotNull(message = "eligible departments are required")
    @Enumerated(EnumType.STRING)
    private List<StudentDepartment> eligibleDepartments;
    private LocalDateTime graduationDate;
    @NotNull(message = "job type is required")
    @Enumerated(EnumType.STRING)
    private JobType jobType;
}
