package com.example.placementmanagementsystem.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Users {
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
