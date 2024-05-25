package com.example.userserviceevebatch.security.model;

import com.example.userserviceevebatch.models.User;
import com.example.userserviceevebatch.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> user = userRepository.findByEmail(username);
       if(user.isEmpty()) throw new UsernameNotFoundException("USer with email "+username+" doesn't exists");

       return new CustomUserDetails(user.get());

    }
}
