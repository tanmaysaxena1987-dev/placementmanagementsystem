package com.example.placementmanagementsystem.user;
import com.example.placementmanagementsystem.recruiter.recruiterdto.RecruiterRegisterRequestDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User mapStudenttoUser(String email, String password, String name, String phoneNumber) {
        User users = new User();
        users.setEmail(email);
        users.setPassword(encoder.encode(password));
        users.setName(name);
        users.setPhoneNumber(phoneNumber);
        users.setRole(UserType.STUDENT);
        users.setEnabled(true);
        users.setEmailVerified(false);
        return users;
    }
    public User mapRecruitertoUser(RecruiterRegisterRequestDto recruiterRegisterRequestDto) {
        User users = new User();
        users.setName(recruiterRegisterRequestDto.getName());
        users.setPassword(encoder.encode(recruiterRegisterRequestDto.getPassword()));
        users.setPhoneNumber(recruiterRegisterRequestDto.getPhoneNumber());
        users.setEmail(recruiterRegisterRequestDto.getEmail());
        users.setRole(UserType.RECRUITER);
        users.setEmailVerified(false);
        users.setEnabled(true);
        return users;
    }
    public User mapCompanytoUser(String email, String name, String password, String phoneNumber) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(encoder.encode(password));
        user.setPhoneNumber(phoneNumber);
        user.setEmailVerified(false);
        user.setEnabled(true);
        user.setRole(UserType.COMPANY);
        return user;
    }
}
