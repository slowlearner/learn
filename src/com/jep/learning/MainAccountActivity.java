package com.jep.learning;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainAccountActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_account);
		
		Button btnOpen = (Button) findViewById(R.id.btnOpenAccount);
		Button btnCreate = (Button) findViewById(R.id.btnCreate);
		Button btnExit = (Button) findViewById(R.id.btnExit);
		
		btnOpen.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent intent  = new Intent();
				intent.setClass(getApplicationContext(), AccountListActivity.class);
				startActivity(intent);
			}
		});
		
		btnCreate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), CreateAccountActivity.class);
				startActivity(intent);
			}
		});		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_account, menu);
		return true;
	}

}
