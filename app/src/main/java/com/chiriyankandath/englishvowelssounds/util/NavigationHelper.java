package com.chiriyankandath.englishvowelssounds.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.chiriyankandath.englishvowelssounds.manager.ProfileManager;
import com.chiriyankandath.englishvowelssounds.manager.ScoreManager;
import com.chiriyankandath.englishvowelssounds.view.ProfileActivity;
import com.chiriyankandath.englishvowelssounds.view.ScoreActivity;
import com.chiriyankandath.englishvowelssounds.view.SelectSubjectActiivty;
import com.chiriyankandath.englishvowelssounds.view.VowelQuestionActivity;

/**
 * Created by puannjoy on 1/13/2016.
 */
public class NavigationHelper {

	private Context context;
	final int NUMBER_OF_QUESTION_IN_LEVEL = 3;


	public NavigationHelper(Activity activity){
		this.context = activity;
	}

	private int count=1;

	/*public ProfileManager getProfileManager(){
		return profileManager;
	}*/


	public boolean continueQuestion(){
		if(count != NUMBER_OF_QUESTION_IN_LEVEL) {
			count += 1;
			return true;
		}
		return false;
	}

	public void startScoreActivity(ScoreManager scoreManager){
		count = 1;
		int score = scoreManager.getScore();
		scoreManager.clearScore();
		Intent intent = new Intent(context,ScoreActivity.class);
		intent.putExtra("SCORE", score);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		context.startActivity(intent);
	}

	public void startEnglishQuestionActivity(){
		Intent intent = new Intent(context,VowelQuestionActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

		context.startActivity(intent);
	}

	public void startMalayalamLearningActivity(){

	}

	public void startMathLearningActivity(){

	}

	public void startSelectSubjectActivity(){
		Intent intent = new Intent(context, SelectSubjectActiivty.class);
		context.startActivity(intent);
	}

	public void startProfileActivity(){
		Intent intent = new Intent(context, ProfileActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		context.startActivity(intent);
	}

	public void AppExit()
	{

		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);

    /*int pid = android.os.Process.myPid();=====> use this if you want to kill your activity. But its not a good one to do.
    android.os.Process.killProcess(pid);*/

	}
}
