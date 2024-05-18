package com.example.userserviceevebatch.repository;

import com.example.userserviceevebatch.models.Token;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface TokenRepository extends JpaRepository<Token,Long> {

    Long countByDeletedAndExpiryAtAfterAndUsersId(Boolean deleted, Date expiryDate,Long usersId);
}
