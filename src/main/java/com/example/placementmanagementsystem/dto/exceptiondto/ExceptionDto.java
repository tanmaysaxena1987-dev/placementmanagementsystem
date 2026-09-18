package com.example.placementmanagementsystem.dto.exceptiondto;

import com.example.placementmanagementsystem.dto.studentdto.StudentRegisterRequestDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionDto {
    private int status;
    private String error;
    private String message;
    private String path;
    @CreationTimestamp
    private LocalDateTime timestamp;

    public ExceptionDto(int status, String error, String message, String path){
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }
}
