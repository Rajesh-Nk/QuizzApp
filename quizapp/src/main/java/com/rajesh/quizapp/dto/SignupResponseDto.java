package com.rajesh.quizapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignupResponseDto {

    private long id;
    private String name;
    private String email;

}
