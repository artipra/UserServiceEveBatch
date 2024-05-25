package com.example.userserviceevebatch.services;

import com.example.userserviceevebatch.exception.InvalidTokenException;
import com.example.userserviceevebatch.exception.TooManyDeviceException;
import com.example.userserviceevebatch.exception.UserNotFoundException;
import com.example.userserviceevebatch.exception.passwordMismatchException;
import com.example.userserviceevebatch.models.Token;
import com.example.userserviceevebatch.models.User;
import com.example.userserviceevebatch.repository.TokenRepository;
import com.example.userserviceevebatch.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;
    private TokenRepository tokenRepository;

    public User signUp(String email,String name,String password){
      User user = new User();
      user.setEmail(email);
      user.setHashedPassword(bCryptPasswordEncoder.encode(password));
      user.setName(name);
      return userRepository.save(user);
    }

    public Token login(String email, String password){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("email id is not exist"));
        if(!bCryptPasswordEncoder.matches(password,user.getHashedPassword()))
            throw new passwordMismatchException("password is not matched. please user correct password or click on forgot password ");
        // if username and password is correct. generate token
//        Long activeToken = tokenRepository.countByDeletedAndExpiryAt(user.getId(),false,new Date());
        Long activeToken = tokenRepository.countByDeletedAndExpiryAtAfterAndUsersId(false,new Date(),user.getId());
        if(activeToken >= 2){
            throw new TooManyDeviceException("you have already logged in too many device. please logout and retry");
        }
//        Long activeToken = tokenRepository.countByDeletedAndExpiryAtAfterAndUsersNotIn(false,new Date(),user.getId());
       // System.out.println("activetoken "+activeToken);
        return tokenRepository.save(generateToken(user));

    }

   private Token generateToken(User user){
       LocalDate currentDate = LocalDate.now();
       LocalDate thirtyDaysLater = currentDate.plusDays(30);
       Date expiryDate = Date.from(thirtyDaysLater.atStartOfDay(ZoneId.systemDefault()).toInstant());
       Token token = new Token();
       token.setExpiryAt(expiryDate);
       token.setValue(RandomStringUtils.randomAlphanumeric(128));
       token.setUsers(user);
       return token;
   }


    public void logout(String token){
        Token validToken = tokenRepository.findByDeletedAndValue(false,token)
                        .orElseThrow(() -> new InvalidTokenException("Invalid Exception"));
        validToken.setDeleted(true);
        tokenRepository.save(validToken);
        }

    public User validateToken(String token){
        Optional<Token> validToken = tokenRepository.findByDeletedAndExpiryAtAfterAndValue(false,new Date(),token);
        return validToken.map(Token::getUsers).orElse(null);
    }

    public User UserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user not found with this id "+id));
    }

}
