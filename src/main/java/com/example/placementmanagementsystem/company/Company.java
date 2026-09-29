package com.example.placementmanagementsystem.company;

import com.example.placementmanagementsystem.application.Application;
import com.example.placementmanagementsystem.job.Job;
import com.example.placementmanagementsystem.offer.Offer;
import com.example.placementmanagementsystem.recruiter.Recruiter;
import com.example.placementmanagementsystem.user.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank
    private String companyName;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @OneToOne
    private Users userProfile;
    @OneToMany(mappedBy = "company")
    private List<Job> job=new ArrayList<>();
    @OneToMany
    private List<Application> application=new ArrayList<>();
    @OneToMany(mappedBy = "company")
    private List<Recruiter> recruiter=new ArrayList<>();
    @NotBlank
    private String location;
    @OneToMany
    private List<Offer> offer=new ArrayList<>();
}
