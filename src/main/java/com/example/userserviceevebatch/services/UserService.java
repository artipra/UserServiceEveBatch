package com.example.userserviceevebatch.services;

import com.example.userserviceevebatch.models.Token;
import com.example.userserviceevebatch.models.User;
import com.example.userserviceevebatch.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;
    public Token login(String email, String password){
    return null;
    }
    public User signUp(String email,String name,String password){
      User user = new User();
      user.setEmail(email);
      user.setHashedPassword(bCryptPasswordEncoder.encode(password));
      user.setName(name);
      return userRepository.save(user);
    }

    public void logout(String token){
    }

    public User validateToken(String Token){
     return null;
    }
}
