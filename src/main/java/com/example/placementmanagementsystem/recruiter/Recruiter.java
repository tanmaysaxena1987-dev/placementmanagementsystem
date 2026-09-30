package com.example.placementmanagementsystem.recruiter;

import com.example.placementmanagementsystem.application.Application;
import com.example.placementmanagementsystem.company.Company;
import com.example.placementmanagementsystem.job.Job;
import com.example.placementmanagementsystem.offer.Offer;
import com.example.placementmanagementsystem.user.User;
import io.swagger.v3.oas.models.info.Contact;
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
public class Recruiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "company_recruiter")
    private Company company;
    @OneToOne
    @JoinColumn(name="user_id",nullable = false,unique = true)
    private User user;
    @OneToMany(mappedBy="recruiter")
    private List<Job> job=new ArrayList<>();
    @OneToMany
    private List<Application> application=new ArrayList<>();
    @OneToMany
    private List<Offer> offer=new ArrayList<>();

}
