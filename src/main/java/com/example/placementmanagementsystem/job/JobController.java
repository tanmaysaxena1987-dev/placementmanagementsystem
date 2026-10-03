package com.example.placementmanagementsystem.job;

import com.example.placementmanagementsystem.job.jobdto.JobRegisterRequestDto;
import com.example.placementmanagementsystem.job.jobdto.JobRegisterResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/job")
@Tag(name="Job Related Operation")
public class JobController {
    @Autowired
    private JobService jobService;
    @Operation(summary = "Post A Job")
    @PostMapping("/registerjob")
    public ResponseEntity<JobRegisterResponseDto> registerJob(@Valid @RequestBody JobRegisterRequestDto jobRegisterRequestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(jobService.registerJob(jobRegisterRequestDto));
    }
}