package com.example.placementmanagementsystem.student;

import com.example.placementmanagementsystem.application.Application;
import com.example.placementmanagementsystem.offer.Offer;
import com.example.placementmanagementsystem.user.Users;
import jakarta.persistence.*;
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
public class Student {
    @Id
    private Integer id;
    @OneToOne
    @JoinColumn(name = "userProfile")
    @MapsId
    private Users usersProfile;
    @NotNull
    private double cgpa;
    @JdbcTypeCode(SqlTypes.VARBINARY)
    private byte[] resume;
    private List<String> skills=new ArrayList<>();
    @OneToOne
    @JoinColumn(name="JobApplication")
    private Application application;
    @OneToOne
    @JoinColumn(name="JobOffer")
    private Offer offer;
}
