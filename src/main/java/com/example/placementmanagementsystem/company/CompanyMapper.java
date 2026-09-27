package com.example.placementmanagementsystem.company;

import com.example.placementmanagementsystem.company.companydtos.CompanyRegisterResponseDto;
import com.example.placementmanagementsystem.company.companydtos.CompanyViewRequestResponseDto;
import com.example.placementmanagementsystem.user.UserType;
import com.example.placementmanagementsystem.user.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    public Company toCompany(Users user, String location) {
        Company company = new Company();
        company.setUserProfile(user);
        company.setCompanyName(user.getName());
        company.setEmail(user.getEmail());
        company.setLocation(location);
        return company;
    }

    public CompanyRegisterResponseDto toCompanyRegisterRequestDto(Company company) {
        CompanyRegisterResponseDto companyRegisterResponseDto=new CompanyRegisterResponseDto();
        companyRegisterResponseDto.setEmail(company.getUserProfile().getEmail());
        companyRegisterResponseDto.setName(company.getUserProfile().getName());
        companyRegisterResponseDto.setPhoneNumber(company.getUserProfile().getPhoneNumber());
        companyRegisterResponseDto.setId(company.getId());
        companyRegisterResponseDto.setLocation(company.getLocation());
        return companyRegisterResponseDto;
    }

    public CompanyViewRequestResponseDto toViewResponseDto(Company company) {
        CompanyViewRequestResponseDto companyViewRequestResponseDto=new CompanyViewRequestResponseDto();
        companyViewRequestResponseDto.setEmail(company.getUserProfile().getEmail());
        companyViewRequestResponseDto.setName(company.getUserProfile().getName());
        companyViewRequestResponseDto.setPhoneNumber(company.getUserProfile().getPhoneNumber());
        companyViewRequestResponseDto.setId(company.getUserProfile().getId());
        companyViewRequestResponseDto.setLocation(company.getLocation());
        return companyViewRequestResponseDto;
    }
}
