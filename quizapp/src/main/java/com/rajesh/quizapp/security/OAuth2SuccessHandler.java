package com.rajesh.quizapp.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajesh.quizapp.dto.LoginResponseDto;
import com.rajesh.quizapp.service.AuthenticationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component

public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final ObjectMapper objectMapper;
    private final AuthenticationService authenticationService;
    public OAuth2SuccessHandler( ObjectMapper objectMapper, @Lazy AuthenticationService authenticationService) {
        this.objectMapper = objectMapper; this.authenticationService = authenticationService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken token= (OAuth2AuthenticationToken) authentication;
        OAuth2User oAuth2User=(OAuth2User) token.getPrincipal();

        String registrationId=token.getAuthorizedClientRegistrationId();
        ResponseEntity<LoginResponseDto> loginResponse = authenticationService.handleOAuth2Login(oAuth2User, registrationId);

        response.setStatus(loginResponse.getStatusCode().value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(objectMapper.writeValueAsString(loginResponse.getBody()));
    }
}
