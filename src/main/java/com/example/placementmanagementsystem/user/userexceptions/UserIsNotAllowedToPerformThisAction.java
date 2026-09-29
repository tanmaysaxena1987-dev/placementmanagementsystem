package com.example.placementmanagementsystem.user.userexceptions;

public class UserIsNotAllowedToPerformThisAction extends RuntimeException {
    public UserIsNotAllowedToPerformThisAction(String message) {
        super(message);
    }
}
