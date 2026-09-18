package com.example.placementmanagementsystem.exception;

public class UserWithEmailAlreadyExist extends RuntimeException {
    public UserWithEmailAlreadyExist(String message) {
        super(message);
    }
}
