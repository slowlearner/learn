package com.jep.learning;

import com.jep.learning.models.Quiz;
import com.jep.learning.services.QuizService;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class QuestionActivity extends CommonActivity {
	private int currentQuestion = 0;
	private Quiz quiz;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		
		QuizService service = new QuizService(getApplicationContext());
		quiz = service.searchQuiz(getIntent().getStringExtra("quiz"));
		
		
		Button back = (Button) findViewById(R.id.btnBack);
		Button next = (Button) findViewById(R.id.btnNext);
		back.setOnClickListener(onBackClickLister);
		next.setOnClickListener(onNextClickLister);
		
		displayQuestion();
		
	}
	private void displayQuestion() {
		TextView titleView = (TextView) findViewById(R.id.textQuestionTitle);
		titleView.setText(quiz.getQuestions().get(currentQuestion).getQuestion());
	}
	private OnClickListener onBackClickLister = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			if(currentQuestion-1 < 0) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), TutorialsActivity.class);
				startActivity(intent);
				return;
			}
			currentQuestion--;			
			displayQuestion();
			
		}

		
	};
	private OnClickListener onNextClickLister = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(currentQuestion+1 >= quiz.getQuestions().size()) {
				return;
			}
			currentQuestion++;
			displayQuestion();			
		}
	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.question, menu);
		return true;
	}

}
