package com.example.placementmanagementsystem.job;

import com.example.placementmanagementsystem.job.jobdto.JobRegisterRequestDto;
import com.example.placementmanagementsystem.job.jobdto.JobRegisterResponseDto;
import com.example.placementmanagementsystem.recruiter.Recruiter;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {
    public Job toRegisterRequestDto(JobRegisterRequestDto dto, Recruiter recruiter) {
        Job job = new Job();
        job.setDesignation( dto.getDesignation() );
        job.setMinCgpa( dto.getMinCgpa() );
        job.setSalary( dto.getSalary() );
        job.setRecruiter( recruiter );
        job.setLocation( dto.getLocation() );
        job.setPreferredSkills(dto.getSkills());
        job.setCompany(recruiter.getCompany());
        return job;
    }
    public JobRegisterResponseDto toRegisterResponseDto(Job job) {
        JobRegisterResponseDto dto = new JobRegisterResponseDto();
        dto.setDesignation(job.getDesignation());
        dto.setLocation( job.getLocation() );
        dto.setId(job.getId());
        dto.setCompany_name(job.getCompany().getCompanyName());
        dto.setSkills(job.getPreferredSkills());
        dto.setRecruiter_email(job.getRecruiter().getEmail());
        dto.setRecruiter_id(job.getRecruiter().getId());
        dto.setRecruiter_name(job.getRecruiter().getRecruiterName());
        dto.setSalary(job.getSalary());
        return dto;
    }
}
