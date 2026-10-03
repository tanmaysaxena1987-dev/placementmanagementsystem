package com.example.placementmanagementsystem.application.applicationdto;

import com.example.placementmanagementsystem.application.ApplicationStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class JobApplicationResponseDto {
    private Integer id;
    private Integer studentId;
    private String studentName;
    private Integer jobId;
    private String jobDesignation;
    private ApplicationStatus status;
    private LocalDateTime appliedAt;
}