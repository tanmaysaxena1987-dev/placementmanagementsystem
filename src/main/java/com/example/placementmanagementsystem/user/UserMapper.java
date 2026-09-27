package com.example.placementmanagementsystem.user;
import com.example.placementmanagementsystem.recruiter.recruiterdto.RecruiterRegisterRequestDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Users mapStudenttoUser(String email, String password, String name, String phoneNumber) {
        Users users = new Users();
        users.setEmail(email);
        users.setPassword(encoder.encode(password));
        users.setName(name);
        users.setPhoneNumber(phoneNumber);
        users.setRole(UserType.STUDENT);
        users.setEnabled(true);
        users.setEmailVerified(false);
        return users;
    }
    public Users mapRecruitertoUser(RecruiterRegisterRequestDto recruiterRegisterRequestDto) {
        Users users = new Users();
        users.setName(recruiterRegisterRequestDto.getName());
        users.setPassword(encoder.encode(recruiterRegisterRequestDto.getPassword()));
        users.setPhoneNumber(recruiterRegisterRequestDto.getPhoneNumber());
        users.setEmail(recruiterRegisterRequestDto.getEmail());
        users.setRole(UserType.RECRUITER);
        users.setEmailVerified(false);
        users.setEnabled(true);
        return users;
    }
    public Users mapCompanytoUser(String email, String name, String password, String phoneNumber) {
        Users user = new Users();
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
