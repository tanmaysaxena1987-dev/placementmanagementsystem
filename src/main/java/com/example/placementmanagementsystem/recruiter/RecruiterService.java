package com.example.placementmanagementsystem.recruiter;

import com.example.placementmanagementsystem.recruiter.recruiterdto.RecruiterRegisterRequestDto;
import com.example.placementmanagementsystem.recruiter.recruiterdto.RecruiterRegisterResponseDto;
import com.example.placementmanagementsystem.user.UserMapper;
import com.example.placementmanagementsystem.user.UserRepo;
import com.example.placementmanagementsystem.user.Users;
import com.example.placementmanagementsystem.user.userexceptions.UserWithEmailAlreadyExists;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruiterService {
    @Autowired
    private UserRepo  userRepo;
    @Autowired
    private RecruiterRepo recruiterRepo;
    @Autowired
    private RecruiterMapper recruiterMapper;
    @Autowired
    private UserMapper userMapper;
    @Transactional
    public RecruiterRegisterResponseDto registerRecruiter(@Valid RecruiterRegisterRequestDto recruiterRegisterRequestDto) {
        if(userRepo.existsByEmail(recruiterRegisterRequestDto.getEmail()))
            throw new UserWithEmailAlreadyExists("User with"+ recruiterRegisterRequestDto.getEmail() +" already exists");
        Users users=userMapper.mapRecruitertoUser(recruiterRegisterRequestDto);
        userRepo.save(users);
        Recruiter recruiter=recruiterMapper.toRecruiter(users);
        recruiterRepo.save(recruiter);
        return recruiterMapper.toRegisterResponseDto(recruiter);
    }
}
