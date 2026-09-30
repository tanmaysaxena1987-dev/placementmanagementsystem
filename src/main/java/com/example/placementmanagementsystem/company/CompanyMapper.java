package com.example.placementmanagementsystem.company;

import com.example.placementmanagementsystem.company.companydtos.CompanyRegisterResponseDto;
import com.example.placementmanagementsystem.company.companydtos.CompanyViewRequestResponseDto;
import com.example.placementmanagementsystem.user.User;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    public Company toCompany(User user, String location) {
        Company company = new Company();
        company.setUser(user);
        company.setLocation(location);
        return company;
    }

    public CompanyRegisterResponseDto toCompanyRegisterRequestDto(Company company) {
        CompanyRegisterResponseDto companyRegisterResponseDto=new CompanyRegisterResponseDto();
        companyRegisterResponseDto.setEmail(company.getUser().getEmail());
        companyRegisterResponseDto.setName(company.getUser().getName());
        companyRegisterResponseDto.setPhoneNumber(company.getUser().getPhoneNumber());
        companyRegisterResponseDto.setId(company.getId());
        companyRegisterResponseDto.setLocation(company.getLocation());
        return companyRegisterResponseDto;
    }

    public CompanyViewRequestResponseDto toViewResponseDto(Company company) {
        CompanyViewRequestResponseDto companyViewRequestResponseDto=new CompanyViewRequestResponseDto();
        companyViewRequestResponseDto.setEmail(company.getUser().getEmail());
        companyViewRequestResponseDto.setName(company.getUser().getName());
        companyViewRequestResponseDto.setPhoneNumber(company.getUser().getPhoneNumber());
        companyViewRequestResponseDto.setId(company.getUser().getId());
        companyViewRequestResponseDto.setLocation(company.getLocation());
        return companyViewRequestResponseDto;
    }
}
