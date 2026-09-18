package com.example.placementmanagementsystem.dto.studentdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class StudentRegisterRequestDto {
    @Getter
    @Setter
    @NotBlank
    private String username;
    @Getter
    @Setter
    @NotBlank
    private String name;
    @Getter
    @Setter
    @Email
    @NotBlank
    private String email;
    @Getter
    @Setter
    @NotBlank
    private String password;
    @Getter
    @Setter
    @NotBlank
    private String department;
    @Getter
    @Setter
    @NotNull
    private int semester;
    @Getter
    @Setter
    @NotNull
    private Double cgpa;
}
