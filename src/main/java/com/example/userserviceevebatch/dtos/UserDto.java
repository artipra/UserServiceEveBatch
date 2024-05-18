package com.example.userserviceevebatch.dtos;

import com.example.userserviceevebatch.models.Roles;
import com.example.userserviceevebatch.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDto {

    private String name;
    private String email;
    private List<Roles> roles;


    public static UserDto from(User user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setRoles(user.getRoles());
        return userDto;
    }
}
