package com.example.placementmanagementsystem.offer;

import com.example.placementmanagementsystem.application.Application;
import com.example.placementmanagementsystem.company.Company;
import com.example.placementmanagementsystem.student.Student;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "application_offer")
    private Application application;
    private BigDecimal salary;
    private LocalDate joiningDate;
}
