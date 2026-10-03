package com.example.placementmanagementsystem.job;

import com.example.placementmanagementsystem.job.jobdto.JobRegisterRequestDto;
import com.example.placementmanagementsystem.job.jobdto.JobRegisterResponseDto;
import com.example.placementmanagementsystem.job.jobdto.ViewAllJobResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @Operation(summary = "View All Jobs")
    @GetMapping("/jobs")
    public ResponseEntity<ViewAllJobResponseDto> viewAllJobs(
            @RequestParam(required = false, defaultValue = "1") int pageNum,
            @RequestParam(required = false, defaultValue = "1") int pageSize,
            @RequestParam(required = false, defaultValue = "id") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") String sortDir) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(jobService.viewAllJobs(pageNum - 1, pageSize, sortBy, sortDir));
    }
}