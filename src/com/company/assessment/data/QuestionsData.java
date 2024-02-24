package com.company.assessment.data;

import java.util.HashMap;

public class QuestionsData {
	
	private String question;
	private HashMap<Integer,String> answer = new HashMap<>();
	private int correctAnswer;
	
	public QuestionsData(String question, HashMap<Integer, String> answer, int correctAnswer) {
		this.question = question;
		this.answer = answer;
		this.correctAnswer = correctAnswer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public HashMap<Integer, String> getAnswer() {
		return answer;
	}

	public void setAnswer(HashMap<Integer, String> answer) {
		this.answer = answer;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}


}
