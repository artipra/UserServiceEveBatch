package com.example.userserviceevebatch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class UserServiceConfigs {

    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
        //return new BCryptPasswordEncoder(18); provide how many round of encryption is needed
        return new BCryptPasswordEncoder();
    }

}
