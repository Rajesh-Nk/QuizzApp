package com.rajesh.quizapp.entities;

public class QuestionWrapper {

	private int id;
	private String question;
	private String option_A;
	private String option_B;
	private String option_C;
	private String option_D;

	public QuestionWrapper(int id, String question, String option_A, String option_B, String option_C,
			String option_D) {
		super();
		this.id = id;
		this.question = question;
		this.option_A = option_A;
		this.option_B = option_B;
		this.option_C = option_C;
		this.option_D = option_D;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "QuestionWrapper [id=" + id + ", question=" + question + ", option_A=" + option_A + ", option_B="
				+ option_B + ", option_C=" + option_C + ", option_D=" + option_D + "]";
	}

}
