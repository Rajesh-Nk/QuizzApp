package com.rajesh.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rajesh.quizapp.entities.Question;
import com.rajesh.quizapp.repository.QuestionRepo;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepo questionRepo;

	// Method to add question
	public ResponseEntity<Question> addQuestion(Question question) {
		try {
			return new ResponseEntity<>(questionRepo.save(question), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new Question(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// Method to get all questions from database

	public ResponseEntity<List<Question>> allQuestion() {
		try {
			return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
	}

	// Service method to get question by id

	public ResponseEntity<Question> findQuestionById(int id) {
		try {
			return new ResponseEntity<>(questionRepo.findById(id).get(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(new Question(), HttpStatus.BAD_REQUEST);
	}

	// Service Method to delete all Question from database

	public ResponseEntity<String> deleteAll() {
		try {
			questionRepo.deleteAll();
			return new ResponseEntity<>("All data Deleted Successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Something went wrong, Please try again!", HttpStatus.BAD_REQUEST);
	}

	// Service Method for delete Question By ID

	public ResponseEntity<String> deleteQuestionById(int id) {
		try {
			questionRepo.deleteById(id);
			return new ResponseEntity<>(id + "Deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Something went wrong, Please try again!", HttpStatus.BAD_REQUEST);
	}

	
	//Service Method to update Question
	public ResponseEntity<Question> updateQuestion(int id,Question question) {
		try {
		Question updatedQ = questionRepo.findById(id).map(q ->{
			q.setQuestion(question.getQuestion());
			q.setDifficultyLevel(question.getDifficultyLevel());
			q.setOption_A(question.getOption_A());
			q.setOption_B(question.getOption_B());
			q.setOption_C(question.getOption_C());
			q.setOption_D(q.getOption_D());
			return q;
		}).get();
		
		return new ResponseEntity<>(questionRepo.save(updatedQ),HttpStatus.CREATED);}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new Question(),HttpStatus.BAD_REQUEST);
	}

}
