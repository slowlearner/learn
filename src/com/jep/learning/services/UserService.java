package com.jep.learning.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.jep.learning.models.User;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.util.Log;

public class UserService {
	private Context context;
	private SharedPreferences prefs;
	public UserService(Context context, SharedPreferences prefs) {
		super();
		this.context = context;
		this.prefs = prefs;
	}
	
	private String serialize(Object o) {
		try {
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream so = new ObjectOutputStream(bo);
			so.writeObject(o);
			so.flush();
			return Base64.encodeToString(bo.toByteArray(), Base64.DEFAULT);			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private Object unserialize(String s) {
		byte b[] = Base64.decode(s, Base64.DEFAULT);
		Object o = null;
		try {
			ByteArrayInputStream bi = new ByteArrayInputStream(b);
			ObjectInputStream si = new ObjectInputStream(bi);
			o = si.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;		
	}
	
	public void saveUsers(ArrayList<User> users) {
		Editor editor = prefs.edit();
		editor.putString("users", serialize(users));
		editor.commit();
	}
	public ArrayList<User> getUsers() {
		String users = prefs.getString("users", "");
		if(users.equals("")) {
			return new ArrayList<User>();
		}
		
		ArrayList<User> list = (ArrayList<User>) unserialize(users);
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
