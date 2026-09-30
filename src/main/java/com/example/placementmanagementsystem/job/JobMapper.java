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
        job.setDescription(dto.getDescription());
        job.setJobType( dto.getJobType() );
        job.setEligibleDepartment(dto.getEligibleDepartments());
        job.setGraduationDate( dto.getGraduationDate() );
        return job;
    }
    public JobRegisterResponseDto toRegisterResponseDto(Job job) {
        JobRegisterResponseDto dto = new JobRegisterResponseDto();
        dto.setDesignation(job.getDesignation());
        dto.setLocation( job.getLocation() );
        dto.setId(job.getId());
        dto.setSkills(job.getPreferredSkills());
        dto.setRecruiter_id(job.getRecruiter().getId());
        dto.setCompany_name(job.getRecruiter().getCompany().getUser().getName());
        dto.setSalary(job.getSalary());
        dto.setDescription(job.getDescription());
        dto.setJobType(job.getJobType());
        dto.setGraduationDate(job.getGraduationDate());
        dto.setEligibleDepartment(job.getEligibleDepartment());
        return dto;
    }
}
