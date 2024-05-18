package com.example.userserviceevebatch.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Roles extends BaseModel{
    private String Value;
}