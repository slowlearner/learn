package com.jep.learning;

import com.jep.learning.services.UserService;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CreateAccountActivity extends CommonActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_account);
		
		Button btnCreate = (Button) findViewById(R.id.btnCreate);
		final TextView txtView = (TextView) findViewById(R.id.editName);
		
		btnCreate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String name = txtView.getText().toString();
				if("".equals(name.trim())) {
					return;
				}
				UserService service = new UserService(getApplicationContext(), prefs);
				service.addUser(name);
				
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), AccountListActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_account, menu);
		return true;
	}

}
