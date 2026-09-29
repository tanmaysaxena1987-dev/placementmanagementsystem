package com.example.placementmanagementsystem.recruiter.recruiterexception;

public class RecruiterIsAlreadyAssignedtoSomeCompany extends RuntimeException {
    public RecruiterIsAlreadyAssignedtoSomeCompany(String message) {
        super(message);
    }
}
