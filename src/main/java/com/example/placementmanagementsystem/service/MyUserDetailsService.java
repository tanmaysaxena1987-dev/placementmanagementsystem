package com.example.placementmanagementsystem.service;


import com.example.placementmanagementsystem.model.Users;
import com.example.placementmanagementsystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users =userRepo.findByUsername(username);
        if(users !=null){
            return User.builder()
                    .username(users.getUsername())
                    .password(users.getPassword())
                    .roles(String.valueOf(users.getAuthorities())).build();
        }

        throw new UsernameNotFoundException("Username not found");
    }
}
