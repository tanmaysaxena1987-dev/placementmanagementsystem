package com.example.placementmanagementsystem.job;

import com.example.placementmanagementsystem.application.Application;
import com.example.placementmanagementsystem.company.Company;
import com.example.placementmanagementsystem.offer.Offer;
import com.example.placementmanagementsystem.recruiter.Recruiter;
import com.example.placementmanagementsystem.student.StudentDepartment;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Jobs")
@Getter
@Setter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String designation;
    private String description;
    @NotNull
    private double salary;
    @NotBlank
    private String location;
    @NotNull
    private double minCgpa;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    @NotNull
    private List<StudentDepartment> eligibleDepartment;
    private LocalDateTime graduationDate;
    @ElementCollection
    private List<String> preferredSkills=new ArrayList<>();
    @Enumerated(EnumType.STRING)
    @NotNull
    private JobType jobType;
    @ManyToOne
    @JoinColumn(name="company_job")
    private Company company;
    @OneToMany(mappedBy = "job")
    private List<Application> application=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name="created_by")
    private Recruiter recruiter;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
