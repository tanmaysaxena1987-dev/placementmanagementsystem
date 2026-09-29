package com.example.placementmanagementsystem.recruiter;

import com.example.placementmanagementsystem.recruiter.recruiterdto.RecruiterRegisterRequestDto;
import com.example.placementmanagementsystem.recruiter.recruiterdto.RecruiterRegisterResponseDto;
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
@RequestMapping("/api/recruiter")
@Tag(name="Recruiter Related Operation")
public class RecruiterController {
    @Autowired
    private RecruiterService  recruiterService;
    @PostMapping("/register")
    @Operation(summary = "Register As a Recruiter")
    public ResponseEntity<RecruiterRegisterResponseDto> registerRecruiter(@Valid @RequestBody RecruiterRegisterRequestDto  recruiterRegisterRequestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(recruiterService.registerRecruiter(recruiterRegisterRequestDto));
    }
}
