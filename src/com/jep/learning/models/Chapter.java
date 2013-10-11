package com.jep.learning.models;

import java.util.ArrayList;

public class Chapter {
	private String title;
	private ArrayList<Tutorial> tutorials;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<Tutorial> getTutorials() {
		return tutorials;
	}
	public void setTutorials(ArrayList<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}
	
	@Override
	public String toString() {
		return title;
	}
}
