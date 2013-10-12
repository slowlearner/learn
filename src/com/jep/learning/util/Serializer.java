package com.jep.learning.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.util.Base64;

public class Serializer {
	public static String serialize(Object o) {
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
	
	public static Object unserialize(String s) {
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
}
