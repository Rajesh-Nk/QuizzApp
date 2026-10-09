package com.rajesh.quizapp.dto;

import com.rajesh.quizapp.entities.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupRequestDto {

    private String name;
    private String email;
    private String password;
    private Role role;
}
