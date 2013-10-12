package com.jep.learning;

import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView lv = (ListView) findViewById(R.id.listMenu);
		
		ArrayList<String> listItems = new ArrayList<String>();
		listItems.add("Tutorials");
		listItems.add("Quizzes");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);		
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(onItemClickListener);
	}
	
	private OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			
			String choice = (String) arg0.getItemAtPosition(arg2);
			Log.e("app", choice);
			
			if("Tutorials".equals(choice)) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), TutorialsActivity.class);
				startActivity(intent);
			} else if ("Quizzes".equals(choice)) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), QuizzesActivity.class);
				startActivity(intent);
			}
			// TODO Auto-generated method stub
			
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
