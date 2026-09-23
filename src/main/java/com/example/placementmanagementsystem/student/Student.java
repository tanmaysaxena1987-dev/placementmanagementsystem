package com.example.placementmanagementsystem.student;

import com.example.placementmanagementsystem.common.models.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;

@Entity
@Getter
@Setter
public class Student{
    @OneToOne
    @JoinColumn(name ="student_profile")
    private Users studentProfile;
    @NotNull
    private double cgpa;
    @Min(1)
    private int semester;
    @NotBlank
    private String rollNo;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private StudentDepartment studentDepartment;
    @JdbcTypeCode(SqlTypes.VARBINARY)
    private byte[] resume;
    private ArrayList<String> skills;
}
