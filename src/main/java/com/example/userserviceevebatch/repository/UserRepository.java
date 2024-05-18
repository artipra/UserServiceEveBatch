package com.example.userserviceevebatch.repository;

import com.example.userserviceevebatch.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

}
