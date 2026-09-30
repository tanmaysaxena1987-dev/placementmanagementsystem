package com.example.placementmanagementsystem.job;

import com.example.placementmanagementsystem.job.jobdto.JobRegisterRequestDto;
import com.example.placementmanagementsystem.job.jobdto.JobRegisterResponseDto;
import com.example.placementmanagementsystem.recruiter.Recruiter;
import com.example.placementmanagementsystem.recruiter.RecruiterRepo;
import com.example.placementmanagementsystem.recruiter.recruiterdto.RecruiterRegisterResponseDto;
import com.example.placementmanagementsystem.recruiter.recruiterexception.RecruiterIsNotAssociatedWithAnyCompany;
import com.example.placementmanagementsystem.user.userexceptions.UserIsNotAllowedToPerformThisAction;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private RecruiterRepo recruiterRepo;
    @Transactional
    public JobRegisterResponseDto registerJob(JobRegisterRequestDto jobRegisterRequestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Recruiter recruiter=recruiterRepo.findByUserEmail(authentication.getName());
        if(!recruiter.getUser().isEnabled())
            throw new UserIsNotAllowedToPerformThisAction("The following Recruiter is not allowed to perform this action");
        if(recruiter.getCompany()==null)
            throw new RecruiterIsNotAssociatedWithAnyCompany("Recruiter is not associated with any company");
        if(!recruiter.getCompany().getUser().isEnabled())
            throw new UserIsNotAllowedToPerformThisAction("The following Company is not allowed to perform this action");
        Job job = jobMapper.toRegisterRequestDto(jobRegisterRequestDto,recruiter);
        job=jobRepo.save(job);
        recruiter.getJob().add(job);
        recruiterRepo.save(recruiter);
        recruiter.getCompany().getJob().add(job);
        JobRegisterResponseDto responseDto=jobMapper.toRegisterResponseDto(job);
        return responseDto;
    }
}
