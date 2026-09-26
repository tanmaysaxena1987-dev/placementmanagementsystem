package com.example.placementmanagementsystem.application;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Application {
    @Id
    private Integer id;
}
