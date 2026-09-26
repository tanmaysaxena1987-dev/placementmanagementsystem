package com.example.placementmanagementsystem.user;
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
}
