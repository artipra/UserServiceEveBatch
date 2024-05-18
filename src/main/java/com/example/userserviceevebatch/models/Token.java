package com.example.userserviceevebatch.models;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@Setter@Getter@Entity
public class Token extends  BaseModel{

    private String value;
    private String expiryAt;
    @ManyToOne
    // ManyToOne or OneToMany can be mentioned at any side whether parent or child,  this is in child entity
    @JoinColumn(name = "user_id")
    private User users;

}
