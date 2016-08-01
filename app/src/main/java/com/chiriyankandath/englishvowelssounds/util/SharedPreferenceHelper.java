package com.chiriyankandath.englishvowelssounds.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by puannjoy on 2/19/2016.
 */
public class SharedPreferenceHelper {
	SharedPreferences prefs;
	SharedPreferences.Editor editor;
	public SharedPreferenceHelper(Context context){
		System.out.println("Punnya context in sharedPrefHelper: "+ context);
		prefs = context.getSharedPreferences("app", Context.MODE_PRIVATE);
		editor = prefs.edit();
	}

	public void saveString(String key, CharSequence value){
		editor.putString(key, value.toString());
		editor.commit();
	}

	public void saveIntValues(String key, int value){
		editor.putInt(key, value);
		editor.commit();

	}

	public void saveBooleanValues(String key, boolean value){
		editor.putBoolean(key, value);
		editor.commit();
	}

	public void saveData(){
		prefs.edit().commit();
	}

	public String getStringValue(String key){
		return prefs.getString(key, "");
	}

	public int getIntValue(String key){
		return prefs.getInt(key, 0);
	}

	public boolean getBooleanValue(String key){
		boolean value = prefs.getBoolean(key,false);
		System.out.println("Punnya  profile status : "+value);
		return  value;
	}
}
