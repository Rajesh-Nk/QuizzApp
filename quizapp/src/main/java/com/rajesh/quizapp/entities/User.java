package com.rajesh.quizapp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String providerId;

    @Enumerated(EnumType.STRING)
    private AuthProviderType provider;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
