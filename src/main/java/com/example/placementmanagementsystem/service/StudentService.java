package com.example.placementmanagementsystem.service;

import com.example.placementmanagementsystem.dto.studentdto.StudentRegisterRequestDto;
import com.example.placementmanagementsystem.dto.studentdto.StudentRegisterResponseDto;
import com.example.placementmanagementsystem.enums.Roles;
import com.example.placementmanagementsystem.enums.Status;
import com.example.placementmanagementsystem.exception.UserWithEmailAlreadyExist;
import com.example.placementmanagementsystem.model.Student;
import com.example.placementmanagementsystem.repo.StudentRepo;
import com.example.placementmanagementsystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private UserRepo userRepo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public ResponseEntity<StudentRegisterResponseDto> registerStudent(StudentRegisterRequestDto studentRegisterRequestDto) {
        if(userRepo.existsByEmail(String.valueOf(studentRegisterRequestDto.getEmail())))
            throw new UserWithEmailAlreadyExist("Users with email " + studentRegisterRequestDto.getEmail() + " already exist");
        Student student= mapStudenttoStudentRegisterRequestDto(studentRegisterRequestDto);
        studentRepo.save(student);
        StudentRegisterResponseDto studentRegisterResponseDto = mapStudenttoStudentRegisterResponseDto(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentRegisterResponseDto);
    }

    private StudentRegisterResponseDto mapStudenttoStudentRegisterResponseDto(Student student) {
        StudentRegisterResponseDto studentRegisterResponseDto = new StudentRegisterResponseDto();
        studentRegisterResponseDto.setCgpa(student.getCgpa());
        studentRegisterResponseDto.setEmail(student.getEmail());
        studentRegisterResponseDto.setRole(student.getRole().toString());
        studentRegisterResponseDto.setId(student.getId());
        studentRegisterResponseDto.setName(student.getName());
        studentRegisterResponseDto.setSemester(student.getSemester());
        studentRegisterResponseDto.setUsername(student.getUsername());
        studentRegisterResponseDto.setDepartment(student.getDepartment());
        return studentRegisterResponseDto;

    }

    private Student mapStudenttoStudentRegisterRequestDto(StudentRegisterRequestDto studentRegisterRequestDto) {
        Student student = new Student();
        student.setCgpa(studentRegisterRequestDto.getCgpa());
        student.setStatus(Status.ACTIVE);
        student.setDepartment(studentRegisterRequestDto.getDepartment());
        student.setName(studentRegisterRequestDto.getName());
        student.setEmail(studentRegisterRequestDto.getEmail());
        student.setPassword(encoder.encode(studentRegisterRequestDto.getPassword()));
        student.setSemester(studentRegisterRequestDto.getSemester());
        student.setRole(Roles.STUDENT);
        student.setUsername(studentRegisterRequestDto.getUsername());
        student.setRole(Roles.STUDENT);
        return  student;
    }
}
