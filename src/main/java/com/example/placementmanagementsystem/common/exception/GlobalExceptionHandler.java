package com.example.placementmanagementsystem.common.exception;

import com.example.placementmanagementsystem.common.dtos.ExceptionDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserWithEmailAlreadyExists.class)
    public ResponseEntity<ExceptionDto> handleUserWithEmailAlreadyExists(Exception ex, HttpServletRequest request) {
        ExceptionDto exceptionDto=new ExceptionDto(ex.getMessage(),409,"CONFLICT",request.getRequestURI());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exceptionDto);
    }
}
