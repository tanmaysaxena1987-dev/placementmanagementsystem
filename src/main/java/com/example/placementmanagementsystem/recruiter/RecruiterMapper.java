package com.example.placementmanagementsystem.recruiter;

import com.example.placementmanagementsystem.recruiter.recruiterdto.RecruiterRegisterRequestDto;
import com.example.placementmanagementsystem.recruiter.recruiterdto.RecruiterRegisterResponseDto;
import com.example.placementmanagementsystem.user.UserType;
import com.example.placementmanagementsystem.user.Users;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RecruiterMapper {
    public Recruiter toRecruiter(Users users) {
        Recruiter recruiter = new Recruiter();
        recruiter.setEmail(users.getEmail());
        recruiter.setRecruiterName(users.getName());
        recruiter.setUserProfile(users);
        return recruiter;
    }

    public RecruiterRegisterResponseDto toRegisterResponseDto(Recruiter recruiter) {
        RecruiterRegisterResponseDto  recruiterRegisterResponseDto = new RecruiterRegisterResponseDto();
        recruiterRegisterResponseDto.setEmail(recruiter.getUserProfile().getEmail());
        recruiterRegisterResponseDto.setName(recruiter.getUserProfile().getName());
        recruiterRegisterResponseDto.setPhoneNumber(recruiter.getUserProfile().getPhoneNumber());
        recruiterRegisterResponseDto.setId(recruiter.getId());
        return recruiterRegisterResponseDto;
    }
}
