package com.jep.learning;

import com.jep.learning.models.Question;
import com.jep.learning.models.Quiz;

import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QuizResultActivity extends CommonActivity {
	Quiz quiz;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz_result);
		
		quiz = (Quiz) getIntent().getSerializableExtra("quiz");
		LinearLayout layout = (LinearLayout) findViewById(R.id.layoutResultContainer);
		
		int ctr = 1;
		int ctrCorrect = 0;
		for(Question question: quiz.getQuestions()) {
			StringBuilder  builder = new StringBuilder();
			builder.append("QUESTION " + ctr++);
			
			TextView tv = new TextView(getApplicationContext());
			if(question.isCorrect()) {
				ctrCorrect++;
				tv.setTextColor(Color.GREEN);
				builder.append("          CORRECT");
			} else {
				tv.setTextColor(Color.RED);
				builder.append("          INCORRECT");
			}
			
			
			
			tv.setText(builder.toString());			
			tv.setTextSize((float) 18.00);
			layout.addView(tv);			
		}
		
		
		TextView txtScore = (TextView) findViewById(R.id.textScore);
		txtScore.setText("" + ctrCorrect + "/" + quiz.getQuestions().size());
		
		Button btnHome = (Button) findViewById(R.id.btnHome);
		Button btnRetake = (Button) findViewById(R.id.btnRetake);
		
		btnHome.setOnClickListener(onHomeClick);
		btnRetake.setOnClickListener(onRetakeClick);
	}
	private OnClickListener onHomeClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), MainActivity.class);
			startActivity(intent);			
		}
	};
	
	private OnClickListener onRetakeClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i = new Intent();			
			i.setClass(getApplicationContext(), QuestionActivity.class);
			i.putExtra("quiz", quiz.getTitle());
			startActivity(i);
			
		}
	};
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz_result, menu);
		return true;
	}

}
