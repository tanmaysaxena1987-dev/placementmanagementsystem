package com.example.placementmanagementsystem.application;

import com.example.placementmanagementsystem.application.applicationdto.JobApplicationResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/application")
@Tag(name = "Application Related Operations")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;
    @PostMapping("/applyforjob/{id}")
    @Operation(summary = "Apply For a Job")
    public ResponseEntity<JobApplicationResponseDto> applyForJob(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(applicationService.applyForJob(id));
    }
}