package com.example.placementmanagementsystem.common.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionDto {
    private String message;
    private int code;
    private String error;
    private String path;
    private LocalDateTime timestamp;
    public ExceptionDto(String message,int code,String error,String path) {
        this.message=message;
        this.code=code;
        this.error=error;
        this.path=path;
        this.timestamp=LocalDateTime.now();
    }
}
