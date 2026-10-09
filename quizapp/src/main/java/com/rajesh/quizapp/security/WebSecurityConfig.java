package com.rajesh.quizapp.security;

import com.rajesh.quizapp.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class WebSecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final JwtAuthFilter jwtAuthFilter;
    private final CustomUserDetailsService customUserDetailsService;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf->csrf.disable())
                .sessionManagement(session->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth->
                        auth
                                // Every GET under /question
                                .requestMatchers(HttpMethod.GET,"/question/**").hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.POST,"/question/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT,"/question/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/question/**").hasRole("ADMIN")
                                .requestMatchers("/auth/**").permitAll()
                                .anyRequest().authenticated()
                )
                //.formLogin(Customizer.withDefaults());
                //.httpBasic(Customizer.withDefaults());
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .oauth2Login(oAuth2->oAuth2
                        .failureHandler((request, response, exception) ->{
                            log.error("Oauth2 error {}",exception.getMessage());
                        })
                        .successHandler(oAuth2SuccessHandler)
                );

                return httpSecurity.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }


}
