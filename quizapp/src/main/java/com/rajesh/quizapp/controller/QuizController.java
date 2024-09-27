package com.rajesh.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rajesh.quizapp.entities.QuestionWrapper;
import com.rajesh.quizapp.entities.Response;
import com.rajesh.quizapp.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	QuizService quizService;

	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String type, @RequestParam int numQ, @RequestParam String title) {
		return quizService.createQuiz(type, numQ, title);
		}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable int id){
		return quizService.getQuizQuestion(id);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> responses){
		
		return quizService.countScore(id,responses);
		
	}
}
