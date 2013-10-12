package com.jep.learning.models;

import java.util.ArrayList;

public class Quiz {
	private String title;
	private ArrayList<Question> questions;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	@Override
	public String toString() {
		return title;
	}
}
