package com.example.placementmanagementsystem.recruiter;

import com.example.placementmanagementsystem.recruiter.recruiterdto.RecruiterRegisterResponseDto;
import com.example.placementmanagementsystem.user.User;
import org.springframework.stereotype.Component;

@Component
public class RecruiterMapper {
    public Recruiter toRecruiter(User users) {
        Recruiter recruiter = new Recruiter();
        recruiter.setUser(users);
        return recruiter;
    }

    public RecruiterRegisterResponseDto toRegisterResponseDto(Recruiter recruiter) {
        RecruiterRegisterResponseDto  recruiterRegisterResponseDto = new RecruiterRegisterResponseDto();
        recruiterRegisterResponseDto.setEmail(recruiter.getUser().getEmail());
        recruiterRegisterResponseDto.setName(recruiter.getUser().getName());
        recruiterRegisterResponseDto.setPhoneNumber(recruiter.getUser().getPhoneNumber());
        recruiterRegisterResponseDto.setId(recruiter.getId());
        return recruiterRegisterResponseDto;
    }
}
