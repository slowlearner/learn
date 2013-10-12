package com.jep.learning.services;

import java.util.ArrayList;

import com.jep.learning.models.User;
import com.jep.learning.util.Serializer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class UserService {
	private Context context;
	private SharedPreferences prefs;
	public UserService(Context context, SharedPreferences prefs) {
		super();
		this.context = context;
		this.prefs = prefs;
	}
	
	public void saveUsers(ArrayList<User> users) {
		Editor editor = prefs.edit();
		editor.putString("users", Serializer.serialize(users));
		editor.commit();
	}
	public ArrayList<User> getUsers() {
		String users = prefs.getString("users", "");
		if(users.equals("")) {
			return new ArrayList<User>();
		}
		
		ArrayList<User> list = (ArrayList<User>) Serializer.unserialize(users);
		return list;
	}
	
	public void clearUsers() {
		saveUsers(new ArrayList<User>());
	}
	public void addUser(String name) {
		ArrayList<User> users = getUsers();
		User u = new User(users.size()+1, name);
		users.add(u);
		saveUsers(users);		
	}
}
