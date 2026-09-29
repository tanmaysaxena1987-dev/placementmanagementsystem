package com.example.placementmanagementsystem.recruiter.recruiterexception;

public class RecruiterIsAlreadyInTheList extends RuntimeException {
    public RecruiterIsAlreadyInTheList(String message) {
        super(message);
    }
}
