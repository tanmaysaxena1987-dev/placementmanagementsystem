package com.example.placementmanagementsystem.recruiter;

import com.example.placementmanagementsystem.application.Application;
import com.example.placementmanagementsystem.company.Company;
import com.example.placementmanagementsystem.job.Job;
import com.example.placementmanagementsystem.offer.Offer;
import com.example.placementmanagementsystem.user.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Recruiter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank
    private String RecruiterName;
    @NotBlank
    @Column(unique = true)
    @Email
    private String email;
    @ManyToOne
    @JoinColumn(name = "company_recruiter")
    private Company company;
    @OneToOne
    private Users userProfile;
    @OneToMany
    private List<Job> job=new ArrayList<>();
    @OneToMany
    private List<Application> application=new ArrayList<>();
    @OneToMany
    private List<Offer> offer=new ArrayList<>();
}
