package com.chiriyankandath.englishvowelssounds.view;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.chiriyankandath.englishvowelssounds.model.QuestionGenerator;
import com.chiriyankandath.englishvowelssounds.R;
import com.chiriyankandath.englishvowelssounds.util.NavigationHelper;

public class VowelQuestionActivity extends AppCompatActivity {

	QuestionGenerator questions;
	
	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		questions = QuestionGenerator.createQuestionGenerator();
		//questions.init();

			setContentView(R.layout.activity_vowel_question);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public void onResume(){
		super.onResume();
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_vowel_question, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
			//noinspection SimplifiableIfStatement
			case R.id.action_settings :
				return true;

			case R.id.action_profile:
				new NavigationHelper(this).startProfileActivity();
				return true;
			case android.R.id.home :
				NavUtils.navigateUpFromSameTask(this);
				return true;
		}


		
		return super.onOptionsItemSelected(item);
	}

	public void updateQuestions(){

	}


}
