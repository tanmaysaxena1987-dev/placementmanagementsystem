package com.example.placementmanagementsystem.student;

import com.example.placementmanagementsystem.application.Application;
import com.example.placementmanagementsystem.offer.Offer;
import com.example.placementmanagementsystem.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name="user_id",nullable = false,unique = true)
    private User user;
    @NotNull
    private double cgpa;
    @JdbcTypeCode(SqlTypes.VARBINARY)
    private byte[] resume;
    @ElementCollection
    private List<String> skills=new ArrayList<>();
    @OneToMany(mappedBy = "student")
    private List<Application> application=new ArrayList<>();
}
