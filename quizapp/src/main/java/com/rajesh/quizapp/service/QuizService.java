package com.rajesh.quizapp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rajesh.quizapp.entities.Question;
import com.rajesh.quizapp.entities.QuestionWrapper;
import com.rajesh.quizapp.entities.Quiz;
import com.rajesh.quizapp.entities.Response;
import com.rajesh.quizapp.repository.QuestionRepo;
import com.rajesh.quizapp.repository.QuizRepo;

@Service
public class QuizService {

	@Autowired
	QuizRepo quizRepo;
	@Autowired
	QuestionRepo questionRepo;

	public ResponseEntity<String> createQuiz(String type, int numQ, String title) {

		List<Question> questions = questionRepo.findRandomQuestionBytype(type, numQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);

		quizRepo.save(quiz);
		return new ResponseEntity<String>("Sucess", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id) {

		Optional<Quiz> quiz = quizRepo.findById(id);
		List<Question> questions = quiz.get().getQuestions();

		List<QuestionWrapper> questionForUser = new ArrayList<>();
		for (Question q : questions) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestion(), q.getOption_A(), q.getOption_B(),
					q.getOption_C(), q.getOption_D());
			questionForUser.add(qw);
		}
		return new ResponseEntity<>(questionForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> countScore(int id, List<Response> responses) {
		Quiz quiz = quizRepo.findById(id).get();

		List<Question> question = quiz.getQuestions();
		//will use this variable to iterate question LIST
		int i = 0;
		//Use to count score
		int score = 0;

		for (Response response : responses) {
			//Check weather response is matching to right_answer or not
			if (response.getResponse().equals(question.get(i).getRightAnswer()))
				score++;
			i++;
		}
		return new ResponseEntity<>(score,HttpStatus.OK);
	}

}
