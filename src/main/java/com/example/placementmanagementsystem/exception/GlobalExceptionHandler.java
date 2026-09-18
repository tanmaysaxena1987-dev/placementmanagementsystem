package com.example.placementmanagementsystem.exception;

import com.example.placementmanagementsystem.dto.exceptiondto.ExceptionDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(UserWithEmailAlreadyExist.class)
    public ResponseEntity<ExceptionDto> handleUserWithEmailAlreadyExist(Exception ex, HttpServletRequest request) {
        ExceptionDto exceptionDto = new ExceptionDto(409,"CONFLICT", ex.getMessage(),request.getRequestURI());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDto);
    }
}
