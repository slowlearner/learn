package com.jep.learning.widgets;

import java.util.List;

import com.jep.learning.models.User;
import com.jep.learning.services.SessionService;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class QuizzesDisabledAdapter<T> extends ArrayAdapter<T> {
	SessionService service;
	public QuizzesDisabledAdapter(Context context, int textViewResourceId,
			List<T> objects, SharedPreferences prefs) {
		super(context, textViewResourceId, objects);
		service = new SessionService(prefs);
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = super.getView(position, convertView, parent);
        view.setEnabled(isEnabled(position));
        return view;
	}
	@Override
	public boolean areAllItemsEnabled() {
		return false;
	}
	@Override
	public boolean isEnabled(int position) {
		User user = service.getCurrentUser();
		User data = service.getUserSession(user);
		
		int chapter = data.getCurrentChapter(); 
		
		if(chapter/2 >= position+1) {
			return true;
		}
		return false;
	}

}
