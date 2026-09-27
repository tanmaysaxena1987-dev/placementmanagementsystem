package com.example.placementmanagementsystem.company;

import com.example.placementmanagementsystem.company.companydtos.CompanyRegisterRequestDto;
import com.example.placementmanagementsystem.company.companydtos.CompanyRegisterResponseDto;
import com.example.placementmanagementsystem.company.companydtos.CompanyViewRequestResponseDto;
import com.example.placementmanagementsystem.recruiter.Recruiter;
import com.example.placementmanagementsystem.recruiter.RecruiterRepo;
import com.example.placementmanagementsystem.recruiter.recruiterexception.RecruiterDoesNotExist;
import com.example.placementmanagementsystem.user.UserMapper;
import com.example.placementmanagementsystem.user.UserRepo;
import com.example.placementmanagementsystem.user.Users;
import com.example.placementmanagementsystem.user.userexceptions.UserWithEmailAlreadyExists;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RecruiterRepo recruiterRepo;
    @Transactional
    public CompanyRegisterResponseDto registerCompany(CompanyRegisterRequestDto companyRegisterRequestDto) {
        if(userRepo.existsByEmail(companyRegisterRequestDto.getEmail()))
            throw new UserWithEmailAlreadyExists("User with Email"+companyRegisterRequestDto.getEmail()+" already exists");
        Users user=userMapper.mapCompanytoUser(companyRegisterRequestDto.getEmail(),
                                        companyRegisterRequestDto.getName(),
                                        companyRegisterRequestDto.getPassword(),
                                        companyRegisterRequestDto.getPhoneNumber());
        userRepo.save(user);
        Company company=companyMapper.toCompany(user,companyRegisterRequestDto.getLocation());
        companyRepo.save(company);
        return companyMapper.toCompanyRegisterRequestDto(company);
    }

    public CompanyViewRequestResponseDto viewProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Company company=companyRepo.findByEmail(authentication.getName());
        return companyMapper.toViewResponseDto(company);
    }

    public String addRecruiter(String email) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Company company = companyRepo.findByEmail(authentication.getName());
        Recruiter recruiter = recruiterRepo.findByEmail(email);
        if (recruiter == null)
            throw new RecruiterDoesNotExist("Recruiter with this email does not exist");
        if (recruiter.getCompany() != null && recruiter.getCompany().equals(company))
            throw new RecruiterIsAlreadyInTheList("Recruiter is already in this company");
        recruiter.setCompany(company);
        recruiterRepo.save(recruiter);
        return "Recruiter has been added";
    }
}
