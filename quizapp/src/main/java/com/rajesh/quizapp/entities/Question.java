package com.rajesh.quizapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String question;
	private String option_A;
	private String option_B;
	private String option_C;
	private String option_D;
	private String rightAnswer;
	private String type;
	private String difficultyLevel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption_A() {
		return option_A;
	}

	public void setOption_A(String option_A) {
		this.option_A = option_A;
	}

	public String getOption_B() {
		return option_B;
	}

	public void setOption_B(String option_B) {
		this.option_B = option_B;
	}

	public String getOption_C() {
		return option_C;
	}

	public void setOption_C(String option_C) {
		this.option_C = option_C;
	}

	public String getOption_D() {
		return option_D;
	}

	public void setOption_D(String option_D) {
		this.option_D = option_D;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", type=" + type + ", difficultyLevel=" + difficultyLevel + ", question="
				+ question + ", option_A=" + option_A + ", option_B=" + option_B + ", option_C=" + option_C
				+ ", option_D=" + option_D + ", rightAnswer=" + rightAnswer + "]";
	}

}
