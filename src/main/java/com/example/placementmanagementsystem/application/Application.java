package com.example.placementmanagementsystem.application;

import com.example.placementmanagementsystem.job.Job;
import com.example.placementmanagementsystem.student.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    @Enumerated(EnumType.STRING)
    public ApplicationStatus status=ApplicationStatus.APPLIED;
    @CreationTimestamp
    private LocalDateTime appliedAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
