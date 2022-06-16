//package com.devsuperior.hroauth.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//public class OauthConfig {
//
//    @Bean
//    public BCryptPasswordEncoder getPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter(){
//       JwtAccessTokenConverter token = new JwtAccessTokenConverter();
//        token.setSigningKey("MY-SECRET-KEY");
//
//        return token;
//    }
//
//    @Bean
//    public JwtTokenStore getTokenStore(){
//        return new JwtTokenStore(new JwtAccessTokenConverter());
//    }
//
//
//}
