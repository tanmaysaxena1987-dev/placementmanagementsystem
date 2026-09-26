package com.example.placementmanagementsystem.user.userdto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionDto {
    private int Code;
    private String Message;
    private String name;
    private String path;
    private LocalDateTime  timestamp;


    public ExceptionDto(int code, String message, String name, String path) {
        this.Code = code;
        this.Message = message;
        this.name = name;
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }
}
