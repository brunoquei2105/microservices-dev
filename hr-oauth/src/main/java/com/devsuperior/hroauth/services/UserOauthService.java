package com.devsuperior.hroauth.services;

import com.devsuperior.hroauth.feign.UserFeignClient;
import com.devsuperior.hroauth.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserOauthService {

    private final UserFeignClient userFeignClient;

    public UserOauthService(UserFeignClient userFeignClient){
        this.userFeignClient = userFeignClient;
    }

    public User findByEmail(String email){
       User user = userFeignClient.findByEmail(email).getBody();

       if (user == null){
           log.error("Email not found: " + email);
           throw new IllegalArgumentException();

       }
        log.info("Email found: " + email);
        return user;

    }
}
