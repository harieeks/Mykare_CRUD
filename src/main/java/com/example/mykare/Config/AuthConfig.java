package com.example.mykare.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class AuthConfig {



    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests(authorize ->authorize
                        .requestMatchers("/register","/authenticate","/hi","/users","/delete-user")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                );
        return httpSecurity.build();
    }
}
