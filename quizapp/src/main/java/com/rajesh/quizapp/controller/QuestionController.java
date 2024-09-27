package com.rajesh.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajesh.quizapp.entities.Question;
import com.rajesh.quizapp.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/add")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		
		return questionService.addQuestion(question);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Question>> allQuestions() {
		return questionService.allQuestion();
	}
	
	@GetMapping("/findBy/{id}")
	public ResponseEntity<Question> findQuestionById(@PathVariable int id) {
		return questionService.findQuestionById(id);	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Question> updateQuestion(@PathVariable int id,@RequestBody Question question){
		return questionService.updateQuestion(id,question);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAll(){
		return questionService.deleteAll();
	}
	@DeleteMapping("/deleteBy/{id}")
	public ResponseEntity<String> deleteQuestionById(@PathVariable int id) {
		return questionService.deleteQuestionById(id);	
	}
}
