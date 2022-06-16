//package com.devsuperior.hroauth.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfig implements AuthorizationServerConfigurer {
//
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    //private final JwtAccessTokenConverter accessTokenConverter;
////    private final JwtTokenStore tokenStore;
//    private final AuthenticationManager authenticationManager;
//
//    public AuthorizationServerConfig(BCryptPasswordEncoder passwordEncoder,AuthenticationManager authenticationManager
//                                     //JwtAccessTokenConverter accessTokenConverter, JwtTokenStore tokenStore
//                                     ){
//        this.passwordEncoder = passwordEncoder;
//        //this.accessTokenConverter = accessTokenConverter;
//       // this.tokenStore = tokenStore;
//        this.authenticationManager = authenticationManager;
//
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer client) throws Exception {
//        client.inMemory()
//                .withClient("myappname123")
//                .secret(passwordEncoder.encode("myappsecret123"))
//                .scopes("read", "write")
//                .authorizedGrantTypes("password")
//                .accessTokenValiditySeconds(86400); //24h em milisegundos, a duração do token
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(authenticationManager);
//                //.tokenStore(tokenStore);
//                //.accessTokenConverter(//accessTokenConverter);
//    }
//}
