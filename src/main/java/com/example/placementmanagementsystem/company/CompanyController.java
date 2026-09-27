package com.example.placementmanagementsystem.company;

import com.example.placementmanagementsystem.company.companydtos.CompanyRegisterRequestDto;
import com.example.placementmanagementsystem.company.companydtos.CompanyRegisterResponseDto;
import com.example.placementmanagementsystem.company.companydtos.CompanyViewRequestResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
@Tag(name="Company Related Operation")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @PostMapping("/register")
    @Operation(summary = "Register As A Company")
    public ResponseEntity<CompanyRegisterResponseDto> registerCompany(@Valid @RequestBody CompanyRegisterRequestDto companyRegisterRequestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(companyService.registerCompany(companyRegisterRequestDto));
    }
    @GetMapping("/viewprofile")
    @Operation(summary = "view company details")
    public ResponseEntity<CompanyViewRequestResponseDto> viewProfile(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(companyService.viewProfile());
    }
    @PostMapping("/addrecruiter")
    @Operation(summary = "Add Recruiter to A company")
    public ResponseEntity<String> addRecruiter(@RequestParam String email){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(companyService.addRecruiter(email));
    }
}
