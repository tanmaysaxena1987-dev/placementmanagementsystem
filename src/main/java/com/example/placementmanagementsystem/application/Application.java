package com.example.placementmanagementsystem.application;

import com.example.placementmanagementsystem.company.Company;
import com.example.placementmanagementsystem.student.Student;
import jakarta.persistence.*;


@Entity
public class Application {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "student_application")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "company_application")
    private Company company;
}
