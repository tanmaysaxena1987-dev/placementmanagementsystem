package com.example.placementmanagementsystem.application;

import com.example.placementmanagementsystem.application.applicationdto.JobApplicationResponseDto;
import com.example.placementmanagementsystem.job.Job;
import com.example.placementmanagementsystem.job.JobRepo;
import com.example.placementmanagementsystem.job.jobexception.JobWithIdNotFound;
import com.example.placementmanagementsystem.job.jobexception.StudentNotEligible;
import com.example.placementmanagementsystem.student.Student;
import com.example.placementmanagementsystem.student.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepo applicationRepo;
    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private JobRepo jobRepo;

    @Transactional
    public JobApplicationResponseDto applyForJob(Integer jobId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Student student = studentRepo.getByUserEmail(authentication.getName());
        Job job = jobRepo.findById(jobId)
                .orElseThrow(() -> new JobWithIdNotFound("Job with id " + jobId + " not found"));
        if(student.getCgpa()<job.getMinCgpa())
            throw new StudentNotEligible("student with cgpa less than"+job.getMinCgpa()+"are  not eligible");

        Application application = new Application();
        application.setStudent(student);
        application.setJob(job);
        application.setStatus(ApplicationStatus.APPLIED);

        applicationRepo.save(application);

        return applicationMapper.toJobApplicationResponseDto(application);
    }
}