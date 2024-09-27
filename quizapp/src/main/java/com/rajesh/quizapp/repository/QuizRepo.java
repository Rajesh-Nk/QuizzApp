package com.rajesh.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajesh.quizapp.entities.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {
	

}
