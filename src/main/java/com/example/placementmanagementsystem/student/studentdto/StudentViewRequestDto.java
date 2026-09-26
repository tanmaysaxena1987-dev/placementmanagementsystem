package com.example.placementmanagementsystem.student.studentdto;

import com.example.placementmanagementsystem.application.Application;
import com.example.placementmanagementsystem.offer.Offer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StudentViewRequestDto {
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private double cgpa;
    private Offer offers;
    private Application application;
    private List<String> skills=new ArrayList<>();
}
