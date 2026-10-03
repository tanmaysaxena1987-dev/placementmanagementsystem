package com.example.placementmanagementsystem.application;

import com.example.placementmanagementsystem.application.applicationdto.JobApplicationResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {
    public JobApplicationResponseDto toJobApplicationResponseDto(Application application) {
        JobApplicationResponseDto dto = new JobApplicationResponseDto();
        dto.setId(application.getId());
        dto.setStudentId(application.getStudent().getId());
        dto.setStudentName(application.getStudent().getUser().getName());
        dto.setJobId(application.getJob().getId());
        dto.setJobDesignation(application.getJob().getDesignation());
        dto.setStatus(application.getStatus());
        dto.setAppliedAt(application.getAppliedAt());
        return dto;
    }
}