package com.jep.learning;

import com.jep.learning.models.Question;
import com.jep.learning.models.Quiz;
import com.jep.learning.services.QuizService;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
		Question question = quiz.getQuestions().get(currentQuestion);
		
		TextView titleView = (TextView) findViewById(R.id.textQuestionTitle);
		titleView.setText(question.getQuestion());
		
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
		radioGroup.setOnCheckedChangeListener(onChange);
		radioGroup.removeAllViews();
		
		for(int i=0; i<question.getChoices().size(); i++) {
			RadioButton b = new RadioButton(getApplicationContext());
			b.setText(question.getChoices().get(i));
			b.setTextColor(Color.BLACK);
			radioGroup.addView(b);
		}
	}
	
	private OnCheckedChangeListener onChange = new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			for(int i=0; i< group.getChildCount() ; i++) {
				if(group.getChildAt(i).getId() == checkedId) {
					Log.e("app", "set answer to" + i);
					quiz.getQuestions().get(currentQuestion).setUserAnswer(i+1);
				}
			}			
		}
	};
	
	
	
	private OnClickListener onBackClickLister = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			if(currentQuestion-1 < 0) {
				back();
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
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), QuizResultActivity.class);
				intent.putExtra("quiz", quiz);
				startActivity(intent);
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
