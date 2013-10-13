package com.jep.learning;

import java.util.ArrayList;

import com.jep.learning.models.Quiz;
import com.jep.learning.services.QuizService;
import com.jep.learning.widgets.QuizzesDisabledAdapter;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class QuizzesActivity extends CommonActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quizzes);
		
		QuizService service = new QuizService(getApplicationContext());
		ArrayList<Quiz> quizzes = service.getAllQuizzes();
		
		ListView lv = (ListView) findViewById(R.id.listQuizzes);
		QuizzesDisabledAdapter<Quiz> adapter = new QuizzesDisabledAdapter<Quiz>(this, android.R.layout.simple_list_item_1, quizzes, prefs);		
		
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(onItemClickListener);
		
				
	}
	
	private OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			Quiz q = (Quiz) arg0.getItemAtPosition(arg2);
			Intent i = new Intent();
			
			i.setClass(getApplicationContext(), QuestionActivity.class);
			i.putExtra("quiz", q.getTitle());
			startActivity(i);
			
		}
	};


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quizzes, menu);
		return true;
	}

}
