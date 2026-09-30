package com.example.placementmanagementsystem.company;

import com.example.placementmanagementsystem.application.Application;
import com.example.placementmanagementsystem.job.Job;
import com.example.placementmanagementsystem.offer.Offer;
import com.example.placementmanagementsystem.recruiter.Recruiter;
import com.example.placementmanagementsystem.user.User;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name="user_id",nullable = false,unique = true)
    private User user;
    @OneToMany(mappedBy = "company")
    private List<Job> job=new ArrayList<>();
    @OneToMany(mappedBy = "company")
    private List<Recruiter> recruiter=new ArrayList<>();
    @NotBlank
    private String location;
}
