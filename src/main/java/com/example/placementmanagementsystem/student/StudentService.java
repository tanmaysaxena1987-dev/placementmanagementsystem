package com.example.placementmanagementsystem.student;

import com.example.placementmanagementsystem.student.studentdto.StudentRegisterRequestDto;
import com.example.placementmanagementsystem.student.studentdto.StudentRegisterResponseDto;
import com.example.placementmanagementsystem.student.studentdto.StudentViewRequestDto;
import com.example.placementmanagementsystem.user.User;
import com.example.placementmanagementsystem.user.UserMapper;
import com.example.placementmanagementsystem.user.UserRepo;
import com.example.placementmanagementsystem.user.userexceptions.UserWithEmailAlreadyExists;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private UserRepo userRepo;
    @Transactional
    public StudentRegisterResponseDto registerStudent(StudentRegisterRequestDto studentRegisterRequestDto) {
        if(userRepo.existsByEmail(studentRegisterRequestDto.getEmail()))
            throw  new UserWithEmailAlreadyExists("User with email"+studentRegisterRequestDto.getEmail()+" already exists");
        User users = userMapper.mapStudenttoUser(studentRegisterRequestDto.getEmail(),
                              studentRegisterRequestDto.getPassword(),
                              studentRegisterRequestDto.getName(),
                              studentRegisterRequestDto.getPhoneNumber());
        userRepo.save(users);
        Student student=studentMapper.toStudentRegisterRequestDto(studentRegisterRequestDto.getCgpa(), users);
        studentRepo.save(student);
        return studentMapper.toStudentRegisterResponseDto(student);
    }

    public StudentViewRequestDto viewStudent() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Student student=studentRepo.getByUserEmail(authentication.getName());
        StudentViewRequestDto studentViewRequestDto=studentMapper.toStudentViewRequestDto(student);
        return studentViewRequestDto;
    }
}
