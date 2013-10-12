package com.jep.learning;

import com.jep.learning.models.User;
import com.jep.learning.services.UserService;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AccountListActivity extends  CommonActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account_list);
		
		ListView lv = (ListView) findViewById(R.id.listAccounts);
		
		UserService  service = new UserService(getApplicationContext(), prefs);		
		ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, service.getUsers());
		lv.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account_list, menu);
		return true;
	}

}
