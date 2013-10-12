package com.jep.learning;

import com.jep.learning.models.User;
import com.jep.learning.services.SessionService;
import com.jep.learning.services.UserService;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class OpenAccountActivity extends  CommonActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_open_account);
		
		ListView lv = (ListView) findViewById(R.id.listAccounts);
		
		UserService  service = new UserService(getApplicationContext(), prefs);		
		ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, service.getUsers());
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(onListItemClick);
	}
	
	private OnItemClickListener onListItemClick = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			User user = (User) arg0.getItemAtPosition(arg2);
			SessionService service = new SessionService(prefs);
			service.setCurrentUser(user);
			
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), MainActivity.class);
			startActivity(intent);
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account_list, menu);
		return true;
	}

}
