package com.example.placementmanagementsystem.student;

import com.example.placementmanagementsystem.student.studentdto.StudentRegisterResponseDto;
import com.example.placementmanagementsystem.student.studentdto.StudentViewRequestDto;
import com.example.placementmanagementsystem.user.Users;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student toStudentRegisterRequestDto(double cgpa, Users users) {
        Student student=new Student();
        student.setCgpa(cgpa);
        student.setUsersProfile(users);
        return student;
    }
    public StudentRegisterResponseDto toStudentRegisterResponseDto(Student student) {
        StudentRegisterResponseDto studentRegisterResponseDto=new StudentRegisterResponseDto();
        studentRegisterResponseDto.setEmail(student.getUsersProfile().getEmail());
        studentRegisterResponseDto.setId(student.getUsersProfile().getId());
        studentRegisterResponseDto.setName(student.getUsersProfile().getName());
        studentRegisterResponseDto.setPhoneNumber(student.getUsersProfile().getPhoneNumber());
        studentRegisterResponseDto.setCgpa(student.getCgpa());
        return studentRegisterResponseDto;
    }
    public StudentViewRequestDto toStudentViewRequestDto(Student student) {
        StudentViewRequestDto studentViewRequestDto=new StudentViewRequestDto();
        studentViewRequestDto.setEmail(student.getUsersProfile().getEmail());
        studentViewRequestDto.setId(student.getUsersProfile().getId());
        studentViewRequestDto.setName(student.getUsersProfile().getName());
        studentViewRequestDto.setPhoneNumber(student.getUsersProfile().getPhoneNumber());
        studentViewRequestDto.setCgpa(student.getCgpa());
        studentViewRequestDto.setApplication(student.getApplication());
        studentViewRequestDto.setOffers(student.getOffer());
        studentViewRequestDto.setSkills(student.getSkills());
        return studentViewRequestDto;
    }
}
