package com.example.userserviceevebatch.security.model;

import com.example.userserviceevebatch.models.Roles;
import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {

    private String authority;
    public CustomGrantedAuthority(Roles role){
        this.authority = role.getValue();

    }
    @Override
    public String getAuthority() {
        return authority;
    }
}
