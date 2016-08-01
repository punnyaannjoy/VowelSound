package com.chiriyankandath.englishvowelssounds.manager;

import android.app.Activity;
import android.content.Context;

import com.chiriyankandath.englishvowelssounds.util.SharedPreferenceHelper;

/**
 * Created by puannjoy on 1/6/2016.
 */
public class ProfileManager {
	SharedPreferenceHelper sharedPreferenceHelper;

	public ProfileManager(Context context){
		System.out.println("Punnya context in ProfileManager: "+ context);

		sharedPreferenceHelper = new SharedPreferenceHelper(context);
	}

	public boolean isProfileCreated(){
		return sharedPreferenceHelper.getBooleanValue("status");
	}

	public void setProfileData(CharSequence name, CharSequence age, int gender){
		System.out.println("Punnya : name : " + name + "  age: " + age + " gender: " + gender);
		sharedPreferenceHelper.saveString("name", name);
		sharedPreferenceHelper.saveString("age", age);
		sharedPreferenceHelper.saveIntValues("gender", gender);
		if(name != null || age != null) {
			sharedPreferenceHelper.saveBooleanValues("status", true);
		}
	}

	public void updateScore(int score){
		sharedPreferenceHelper.saveIntValues("score", score);

	}

	public CharSequence getProfileName(){
		return sharedPreferenceHelper.getStringValue("name");
	}

	public CharSequence getProfileAge(){
		return sharedPreferenceHelper.getStringValue("age");
	}

	public int getProfileGender(){
		return sharedPreferenceHelper.getIntValue("gender");
	}

	public int getProfileTopScore(){
		return sharedPreferenceHelper.getIntValue("score");
	}
}
