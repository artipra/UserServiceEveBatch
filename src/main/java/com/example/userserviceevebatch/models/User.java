package com.example.userserviceevebatch.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class User extends BaseModel {

    private String name;
    private String hashedPassword;
    private String email;
    private boolean isEmailVerified;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Roles> roles;
    //it will result same way as ManyToOne in child entity if mention at both side
    // and benefits that you can apply cascade in parent class
    // but construct different result when only use in parent table
//    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
//    private List<Token> tokens;

}
