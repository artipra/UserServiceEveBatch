package com.example.userserviceevebatch.security.model;

import com.example.userserviceevebatch.models.Roles;
import com.example.userserviceevebatch.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CustomUserDetails implements UserDetails {
    
    private String username;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private List<CustomGrantedAuthority> grantedAuthorities = new ArrayList<>();


     public CustomUserDetails(User user){
         this.username = user.getEmail();
         this.password = user.getHashedPassword();
         this.accountNonExpired=true;
         this.accountNonLocked=true;
         this.credentialsNonExpired=true;
         this.enabled=true;
        //granted authority setting the roles
         for(Roles role : user.getRoles()){
             this.grantedAuthorities.add(new CustomGrantedAuthority(role));
         }


     }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
