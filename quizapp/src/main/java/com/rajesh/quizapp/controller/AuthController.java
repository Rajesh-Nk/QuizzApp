package com.rajesh.quizapp.controller;

import com.rajesh.quizapp.dto.LoginRequestDto;
import com.rajesh.quizapp.dto.LoginResponseDto;
import com.rajesh.quizapp.dto.SignupRequestDto;
import com.rajesh.quizapp.dto.SignupResponseDto;
import com.rajesh.quizapp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){

        return ResponseEntity.ok(authenticationProvider.login(loginRequestDto));

    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto){

        return ResponseEntity.ok(authenticationProvider.signup(signupRequestDto));

    }
}
