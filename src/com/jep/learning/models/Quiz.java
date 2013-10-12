package com.jep.learning.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Quiz implements Serializable{
	private static final long serialVersionUID = 3756700621465589538L;
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
