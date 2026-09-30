package com.example.placementmanagementsystem.student;

import com.example.placementmanagementsystem.student.studentdto.StudentRegisterResponseDto;
import com.example.placementmanagementsystem.student.studentdto.StudentViewRequestDto;
import com.example.placementmanagementsystem.user.User;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student toStudentRegisterRequestDto(double cgpa, User users) {
        Student student=new Student();
        student.setCgpa(cgpa);
        student.setUser(users);
        return student;
    }
    public StudentRegisterResponseDto toStudentRegisterResponseDto(Student student) {
        StudentRegisterResponseDto studentRegisterResponseDto=new StudentRegisterResponseDto();
        studentRegisterResponseDto.setEmail(student.getUser().getEmail());
        studentRegisterResponseDto.setId(student.getId());
        studentRegisterResponseDto.setName(student.getUser().getName());
        studentRegisterResponseDto.setPhoneNumber(student.getUser().getPhoneNumber());
        studentRegisterResponseDto.setCgpa(student.getCgpa());
        return studentRegisterResponseDto;
    }
    public StudentViewRequestDto toStudentViewRequestDto(Student student) {
        StudentViewRequestDto studentViewRequestDto=new StudentViewRequestDto();
        studentViewRequestDto.setEmail(student.getUser().getEmail());
        studentViewRequestDto.setId(student.getId());
        studentViewRequestDto.setName(student.getUser().getName());
        studentViewRequestDto.setPhoneNumber(student.getUser().getPhoneNumber());
        studentViewRequestDto.setCgpa(student.getCgpa());
        studentViewRequestDto.setApplication(student.getApplication());
        studentViewRequestDto.setOffers(student.getOffer());
        studentViewRequestDto.setSkills(student.getSkills());
        return studentViewRequestDto;
    }
}
