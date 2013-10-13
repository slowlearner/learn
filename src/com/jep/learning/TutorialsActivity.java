package com.jep.learning;

import java.util.ArrayList;

import com.jep.learning.models.Chapter;
import com.jep.learning.services.TutorialService;
import com.jep.learning.widgets.TutorialsDisabledArrayAdapter;

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TutorialsActivity extends CommonActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutorials);		
		
		TutorialService service = new TutorialService(getApplicationContext());
		ArrayList<Chapter> chapters = service.getAllTutorials();
		
		
		ListView lv = (ListView) findViewById(R.id.listChapters);
		TutorialsDisabledArrayAdapter<Chapter> adapter = new TutorialsDisabledArrayAdapter<Chapter>(this, android.R.layout.simple_list_item_1, chapters, prefs);		
		
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(onItemClickListener);
		
				
	}
	
		
	
	private OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			Chapter c = (Chapter) arg0.getItemAtPosition(arg2);
			Intent i = new Intent();
			
			i.setClass(getApplicationContext(), TutorialDetailActivity.class);
			i.putExtra("chapter", c.getTitle());
			startActivity(i);
			
		}
	};
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tutorials, menu);
		return true;
	}
}
