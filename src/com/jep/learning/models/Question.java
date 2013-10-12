package com.jep.learning.models;

import java.util.ArrayList;

import android.util.Log;

public class Question {
	private String question;
	private ArrayList<String> choices;
	private int answer;
	private int userAnswer;
	
	public int getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(int userAnswer) {
		this.userAnswer = userAnswer;
	}
	public boolean isCorrect() {
		Log.e("app", "answer: " + answer+ " user_answer " +  userAnswer);
		return userAnswer == answer;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public ArrayList<String> getChoices() {
		return choices;
	}
	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
}
