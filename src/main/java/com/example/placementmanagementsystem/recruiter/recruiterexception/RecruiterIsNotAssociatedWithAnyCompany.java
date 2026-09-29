package com.example.placementmanagementsystem.recruiter.recruiterexception;

public class RecruiterIsNotAssociatedWithAnyCompany extends RuntimeException {
    public RecruiterIsNotAssociatedWithAnyCompany(String message) {
        super(message);
    }
}
