package com.example.placementmanagementsystem.common.service;

import com.example.placementmanagementsystem.user.Users;
import com.example.placementmanagementsystem.user.UserRepo;
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
       Users users =userRepo.findByEmail(username);
       if(users !=null){
           return User.builder()
                   .username(users.getEmail())
                   .password(users.getPassword())
                   .roles(String.valueOf(users.getRole())).build();
       }
       else
           throw new UsernameNotFoundException(username);
    }
}
