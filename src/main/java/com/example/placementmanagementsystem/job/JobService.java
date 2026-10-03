package com.example.placementmanagementsystem.job;

import com.example.placementmanagementsystem.job.jobdto.JobRegisterRequestDto;
import com.example.placementmanagementsystem.job.jobdto.JobRegisterResponseDto;
import com.example.placementmanagementsystem.job.jobdto.ViewAllJobResponseDto;
import com.example.placementmanagementsystem.recruiter.Recruiter;
import com.example.placementmanagementsystem.recruiter.RecruiterRepo;
import com.example.placementmanagementsystem.recruiter.recruiterexception.RecruiterIsNotAssociatedWithAnyCompany;
import com.example.placementmanagementsystem.user.userexceptions.UserIsNotAllowedToPerformThisAction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

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
        JobRegisterResponseDto responseDto=jobMapper.toRegisterResponseDto(job);
        return responseDto;
    }

    public ViewAllJobResponseDto viewAllJobs(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Job> jobPage = jobRepo.findAll(pageable);

        ViewAllJobResponseDto dto = new ViewAllJobResponseDto();
        dto.setContent(jobPage.getContent().stream()
                .map(jobMapper::toRegisterResponseDto)
                .collect(Collectors.toList()));
        dto.setPageNumber(jobPage.getNumber());
        dto.setPageSize(jobPage.getSize());
        dto.setTotalElements(jobPage.getTotalElements());
        dto.setTotalPages(jobPage.getTotalPages());
        dto.setLast(jobPage.isLast());
        dto.setFirst(jobPage.isFirst());
        return dto;
    }
}