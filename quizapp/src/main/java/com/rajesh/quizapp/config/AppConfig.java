package com.rajesh.quizapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {

        return configuration.getAuthenticationManager();
    }

//    @Bean
//    UserDetailsService userDetailsService(){
//        UserDetails admin= User.builder()
//                .email("admin1")
//                .password(passwordEncoder().encode("123@admin"))
//                .roles("ADMIN").build();
//
//        UserDetails user= User.builder()
//                .email("user1")
//                .password(passwordEncoder().encode("123@user"))
//                .roles("USER").build();
//
//        return new InMemoryUserDetailsManager(admin,user);
//    }
}
