package com.jep.learning;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

public class CommonActivity extends Activity {
	public static final String PREFS_NAME = "com.jep.learning";
	protected SharedPreferences prefs;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);		
		prefs = getSharedPreferences(PREFS_NAME, 0);		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	    // Respond to the action bar's Up/Home button
	    case android.R.id.home:
	    	back();	        
	        return true;
	    }
	    return super.onOptionsItemSelected(item);
	}
	
	public void back() {
		NavUtils.navigateUpFromSameTask(this);
	}

}
