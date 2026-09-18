package com.example.placementmanagementsystem.model;

import com.example.placementmanagementsystem.enums.Roles;
import com.example.placementmanagementsystem.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_role",discriminatorType=DiscriminatorType.STRING)
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    @Column(unique = true)
    @NotBlank
    private String username;
    @Getter
    @Setter
    @NotBlank
    private String name;
    @Getter
    @Setter
    @Column(unique = true)
    @Email
    @NotBlank
    private String email;
    @Getter
    @Setter
    @NotBlank
    private String password;
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Roles role;
    @Getter
    @Setter
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Getter
    @Setter
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Status status;


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }
}
