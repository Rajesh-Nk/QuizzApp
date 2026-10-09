package com.rajesh.quizapp.repository;

import com.rajesh.quizapp.entities.AuthProviderType;
import com.rajesh.quizapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String username);

    Optional<Object> findByProviderAndProviderId(AuthProviderType authProviderType, String providerId);
}
