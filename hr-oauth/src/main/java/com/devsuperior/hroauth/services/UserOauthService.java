package com.devsuperior.hroauth.services;

import com.devsuperior.hroauth.feign.UserFeignClient;
import com.devsuperior.hroauth.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserOauthService implements UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(username).getBody();

        if (user == null){
            log.error("Email not found: " + username);
            throw new UsernameNotFoundException("Email not found");

        }
        log.info("Email found: " + username);
        return user;
    }
}
