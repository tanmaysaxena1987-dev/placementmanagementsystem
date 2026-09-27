package com.example.placementmanagementsystem.job;

import com.example.placementmanagementsystem.company.Company;
import com.example.placementmanagementsystem.recruiter.Recruiter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Job {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name="company_job")
    private Company company;
    @ManyToOne
    @JoinColumn(name="recruiter_job")
    private Recruiter recruiter;
}
