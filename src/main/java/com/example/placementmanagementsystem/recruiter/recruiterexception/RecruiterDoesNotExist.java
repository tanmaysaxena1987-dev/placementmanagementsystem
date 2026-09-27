package com.example.placementmanagementsystem.recruiter.recruiterexception;

public class RecruiterDoesNotExist extends RuntimeException {
    public RecruiterDoesNotExist(String message) {
        super(message);
    }
}
