package com.jep.learning.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.jep.learning.models.Question;
import com.jep.learning.models.Quiz;

import android.content.Context;
import android.util.Log;

public class QuizService {
	Context context;
	public QuizService(Context context) {
		this.context = context;
	}
	
	public Quiz searchQuiz(String quizTitle) {
		ArrayList<Quiz> quizzes = getAllQuizzes();
		
		for(Quiz quiz: quizzes) {
			if(quiz.getTitle().equals(quizTitle)) {
				return quiz;
			}
		}		
		return null;
	}
	public Question readFile(String filename) {
		
		
		Question question = new Question();
		try {
			InputStream is = context.getAssets().open(filename);
		 	Scanner scanner = new Scanner(is);
		 	
		 	
		 	
		 	question.setQuestion(scanner.nextLine());
		 	int answer = Integer.parseInt(scanner.nextLine());
		 	question.setAnswer(answer);
		 	
		 	ArrayList<String> choices = new ArrayList<String>();
		 	while(scanner.hasNext()) {		 		
		 		choices.add(scanner.nextLine());
		 		question.setChoices(choices);
		 	}		 	
		 			 	
		} catch (Exception e) {
			Log.e("app", "error: " + e.getMessage() + " " + filename + " " + e.getClass());
		}
		
		return question;
	}
	
	public ArrayList<Quiz> getAllQuizzes() {
		ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
		
		 try {
			 	InputStream is = context.getAssets().open("quizzes.txt");
			 	Scanner scanner = new Scanner(is);
			 	
			 	
			 	while(scanner.hasNext()) {
			 		String line = scanner.nextLine();
			 		String[] s = line.split(":");
			 		
			 		Quiz quiz = new Quiz();
			 		quiz.setTitle(s[0]);
			 		
			 		String[] pages = s[1].split(",");
			 		
			 		
			 		ArrayList<Question> questions = new ArrayList<Question>();
			 		for(int i=0; i<pages.length; i++) {
			 			String questionfile = pages[i];
			 			Question q = readFile(questionfile);
			 			questions.add(q);
			 		}
			 		quiz.setQuestions(questions);
			 		quizzes.add(quiz);			 		
			 	}
			 	
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	        	Log.e("app-", e.getMessage());
	        }
		 Log.e("app", "" + quizzes.size());
		 return quizzes;
	}
}
