package com.example.placementmanagementsystem.job.jobexception;

public class StudentNotEligible extends RuntimeException {
    public StudentNotEligible(String message) {
        super(message);
    }
}
