package com.jep.learning.services;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.jep.learning.models.User;
import com.jep.learning.util.Serializer;

public class SessionService {
	private SharedPreferences prefs;
	public SessionService(SharedPreferences prefs) {
		this.prefs = prefs;
	}
	public void saveUserSession(User user) {
		User user_in_session = getUser(user.getId());
		if(user_in_session == null) {
			String key = "session_user" + user.getId();
			String u = Serializer.serialize(user);
			Editor editor = prefs.edit();
			editor.putString(key, u);
			editor.commit();
		}		
	}
	
	public void setCurrentUser(User user) {
		String key = "session_current_user";
		String u = Serializer.serialize(user);
		Editor editor = prefs.edit();
		editor.putString(key, u);
		editor.commit();
	}
	
	public User getCurrentUser() {
		String key = "session_current_user";
		String u = prefs.getString(key, "");
		if("".equals(u)) {
			return null;
		}		
		User user = (User) Serializer.unserialize(u);
		return user;
	}
	
	public User getUser(int id) {
		String key = "session_user" + id;
		String u = prefs.getString(key, "");
		if("".equals(u)) {
			return null;
		}		
		User user = (User) Serializer.unserialize(u);
		return user;
	}
	
	
}
