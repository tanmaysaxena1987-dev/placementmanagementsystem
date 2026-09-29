package com.example.placementmanagementsystem.job;

import com.example.placementmanagementsystem.application.Application;
import com.example.placementmanagementsystem.company.Company;
import com.example.placementmanagementsystem.offer.Offer;
import com.example.placementmanagementsystem.recruiter.Recruiter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

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
    @NotNull
    private double salary;
    @NotBlank
    private String location;
    @NotNull
    private double minCgpa;
    private List<String> preferredSkills=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name="company_job")
    private Company company;
    @OneToMany
    private List<Application> application=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name="recruiter_job")
    private Recruiter recruiter;
    @OneToMany
    private List<Offer> offer=new ArrayList<>();
}
