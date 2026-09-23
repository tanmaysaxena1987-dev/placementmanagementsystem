package com.example.placementmanagementsystem.common.models;

import com.example.placementmanagementsystem.common.enums.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    @CreationTimestamp
    private String CreatedAt;
    @UpdateTimestamp
    private String UpdatedAt;
    @NotBlank
    private String phoneNumber;
    @Column(nullable = false)
    private boolean enabled;
    @Column(nullable = false)
    private boolean emailVerified;
    @Enumerated(EnumType.STRING)
    private Roles roles;
}
