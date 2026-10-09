package com.rajesh.quizapp.service;

import com.rajesh.quizapp.dto.LoginRequestDto;
import com.rajesh.quizapp.dto.LoginResponseDto;
import com.rajesh.quizapp.dto.SignupRequestDto;
import com.rajesh.quizapp.dto.SignupResponseDto;
import com.rajesh.quizapp.entities.AuthProviderType;
import com.rajesh.quizapp.entities.Role;
import com.rajesh.quizapp.entities.User;
import com.rajesh.quizapp.repository.UserRepository;
import com.rajesh.quizapp.security.AuthUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication= authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getEmail(),loginRequestDto.getPassword())
                );

        //UserDetails userDetails= (UserDetails) authentication.getPrincipal();
        User user= userRepository.findByEmail(loginRequestDto.getEmail()).orElseThrow();

        String token= authUtil.generateToken(user);
        return new LoginResponseDto(token, user.getId());


    }

    public User signUpInternal(SignupRequestDto signupRequestDto, AuthProviderType authProviderType, String providerId) {
        User user = userRepository.findByEmail(signupRequestDto.getEmail()).orElse(null);

        if(user != null) throw new IllegalArgumentException("User already exists");

        // Ensure name is not null or blank
        String name = (signupRequestDto.getName() != null && !signupRequestDto.getName().isBlank())
                ? signupRequestDto.getName()
                : "Default Name"; // Fallback name, if necessary


        user = User.builder()
                .email(signupRequestDto.getEmail())
                .name(name)
                .providerId(providerId)
                .provider(authProviderType)
                .role(signupRequestDto.getRole()) // Role.USER
                .build();
        if (authProviderType == AuthProviderType.EMAIL) {
            // Set the encoded password only for email-based users
            user.setPassword(passwordEncoder.encode(signupRequestDto.getPassword()));
        } else {
            // For other auth providers, set a default value for password field
            user.setPassword(passwordEncoder.encode("OAUTH2_DEFAULT_PASSWORD")); // Use a safe value
        }

        userRepository.save(user);
        return user;
    }


    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {
        User user = signUpInternal(signupRequestDto, AuthProviderType.EMAIL, null);

        return new SignupResponseDto( user.getId(), user.getEmail(), user.getName());
    }

    @Transactional
    public ResponseEntity<LoginResponseDto> handleOAuth2Login(OAuth2User oAuth2User, String registrationId) {

        // fetch providerType and providerId

        AuthProviderType authProviderType = authUtil.getProviderTypeFromRegistrationId(registrationId);
        String providerId = authUtil.getProviderIdFromOAuth2User(oAuth2User, registrationId);

        User user= (User) userRepository.findByProviderAndProviderId(authProviderType, providerId).orElse(null);
        String email= oAuth2User.getAttribute("email");

        // Extract name from OAuth2User
        String name = oAuth2User.getAttribute("name");
        if (name == null || name.isBlank()) {
            name = authUtil.determineUsernameFromOAuth2User(oAuth2User, registrationId, providerId);
        }


        User userEmail= userRepository.findByEmail(email).orElse(null);
        // save the providerType and providerId in the database


        if (user == null && userEmail == null){
            // Otherwise first signup then login

            // signup
            String username= authUtil.determineUsernameFromOAuth2User(oAuth2User, registrationId, providerId);
            user = signUpInternal(new SignupRequestDto(name, email,null, Role.USER), authProviderType, providerId);

        } else if(user != null) {
            if(email != null && !email.isBlank() && !email.equals(user.getEmail())) {
                user.setEmail(email);
                userRepository.save(user);
            }
        } else {
            throw new BadCredentialsException("This email is already registered with provider "+userEmail);
        }

        // If user hss an account log in directly
        LoginResponseDto loginResponseDto = new LoginResponseDto(authUtil.generateToken(user), user.getId());
        return ResponseEntity.ok(loginResponseDto);


    }
}
