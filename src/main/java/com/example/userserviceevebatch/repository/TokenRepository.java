package com.example.userserviceevebatch.repository;

import com.example.userserviceevebatch.models.Token;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token,Long> {

    Long countByDeletedAndExpiryAtAfterAndUsersId(Boolean deleted, Date expiryDate,Long usersId);
    Optional<Token> findByDeletedAndValue(boolean deleted,String token);

    Optional<Token> findByDeletedAndExpiryAtAfterAndValue(boolean deleted,Date date,String token);
}
