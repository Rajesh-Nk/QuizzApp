package com.rajesh.quizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rajesh.quizapp.entities.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

	public static final String createQuizQuery = "SELECT * FROM question q where q.type=:type ORDER BY RAND() LIMIT :numQ ";

	@Query(value=createQuizQuery,nativeQuery = true )
	List<Question> findRandomQuestionBytype(String type,int numQ);

}
