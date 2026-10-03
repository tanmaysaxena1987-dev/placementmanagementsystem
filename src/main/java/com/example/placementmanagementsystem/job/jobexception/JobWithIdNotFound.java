package com.example.placementmanagementsystem.job.jobexception;

public class JobWithIdNotFound extends RuntimeException {
    public JobWithIdNotFound(String message) {
        super(message);
    }
}
