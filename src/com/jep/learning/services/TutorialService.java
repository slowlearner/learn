package com.jep.learning.services;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import android.content.Context;
import android.os.PatternMatcher;
import android.util.Log;

import com.jep.learning.models.Chapter;
import com.jep.learning.models.Tutorial;

public class TutorialService {
	private Context context;
	public TutorialService(Context context) {
		this.context = context;
	}
	
	public Tutorial readFile(String filename) {
		
		StringBuilder body = new StringBuilder();
		String title = "";
		try {
			InputStream is = context.getAssets().open(filename);
		 	Scanner scanner = new Scanner(is);
		 	
		 	title = scanner.nextLine();
		 	
		 	
		 	while(scanner.hasNext()) {		 		
		 		body.append(scanner.nextLine());
		 		body.append("\n");
		 	}		 	
		 			 	
		} catch (Exception e) {
			Log.e("app", "error: " + e.getMessage());
		}
		
		return new Tutorial(title, body.toString());
	}
	public Chapter searchChapter(String chapterName) {
		ArrayList<Chapter> chapters = getAllTutorials();
		
		for(Chapter chapter: chapters) {
			if(chapter.getTitle().equals(chapterName)) {
				return chapter;
			}
		}		
		return null;
	}
	public ArrayList<Chapter> getAllTutorials() {
		ArrayList<Chapter> chapters = new ArrayList<Chapter>();
		
		String filename = "tutorials.txt";
		 try {
			 	InputStream is = context.getAssets().open("tutorials.txt");
			 	Scanner scanner = new Scanner(is);
			 	
			 	
			 	while(scanner.hasNext()) {
			 		String line = scanner.nextLine();
			 		String[] s = line.split(":");
			 		
			 		Chapter chapter = new Chapter();
			 		chapter.setTitle(s[0]);
			 		
			 		String[] pages = s[1].split(",");
			 		
			 		
			 		ArrayList<Tutorial> tutorials = new ArrayList<Tutorial>();
			 		for(int i=0; i<pages.length; i++) {
			 			String tutorialfile = pages[i];
			 			Tutorial t = readFile(tutorialfile);
			 			tutorials.add(t);
			 		}
			 		chapter.setTutorials(tutorials);
			 		chapters.add(chapter);			 		
			 	}
			 	
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	        	Log.e("app", e.getMessage());
	        }
		 return chapters;
	}
}
