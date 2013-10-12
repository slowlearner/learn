package com.jep.learning.models;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8735423236809160650L;
	private int id;
	private String name;
	private int currentChapter = 0;
	
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrentChapter() {
		return currentChapter;
	}
	public void setCurrentChapter(int currentChapter) {
		this.currentChapter = currentChapter;
	}
	@Override
	public String toString() {
		return name;
	}
	
}
