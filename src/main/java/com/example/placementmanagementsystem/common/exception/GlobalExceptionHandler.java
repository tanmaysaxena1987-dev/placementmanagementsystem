package com.example.placementmanagementsystem.common.exception;

import com.example.placementmanagementsystem.user.userdto.ExceptionDto;
import com.example.placementmanagementsystem.user.userexceptions.UserWithEmailAlreadyExists;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserWithEmailAlreadyExists.class)
    public ResponseEntity<ExceptionDto> HandlerUserWithEmailAlreadyExists(Exception ex, HttpServletRequest req) {
        ExceptionDto response=new ExceptionDto(409, ex.getMessage(),"CONFLICT",req.getRequestURI());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }
}
