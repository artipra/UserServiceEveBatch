package com.example.userserviceevebatch.controllers;

import com.example.userserviceevebatch.dtos.LogOutRequestDto;
import com.example.userserviceevebatch.dtos.LoginRequestDto;
import com.example.userserviceevebatch.dtos.SignUpRequestDto;
import com.example.userserviceevebatch.dtos.UserDto;
import com.example.userserviceevebatch.models.Token;
import com.example.userserviceevebatch.models.User;
import com.example.userserviceevebatch.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    @PostMapping("signup")
  public UserDto signUp(@RequestBody SignUpRequestDto signUpRequestDto){
       User savedUser =  userService.signUp(
               signUpRequestDto.getEmail(),
               signUpRequestDto.getName(),
               signUpRequestDto.getPassword());
    return UserDto.from(savedUser);

  }

  @PostMapping("/login")
  public Token login(@RequestBody LoginRequestDto loginRequestDto){
   return userService.login(loginRequestDto.getEmail(),loginRequestDto.getPassword());
  }

  @PostMapping("logout")
  public ResponseEntity<Void> logout(@RequestBody LogOutRequestDto logOutRequestDto ){
    userService.logout(logOutRequestDto.getValue());
    return new ResponseEntity<>(HttpStatus.OK);
  }

    @GetMapping("/validate/{token}")
    public UserDto validateToken(@PathVariable String token) {
        User user = userService.validateToken(token);
        return UserDto.from(user);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        User user = userService.UserById(id);
        return UserDto.from(user);
    }

}
