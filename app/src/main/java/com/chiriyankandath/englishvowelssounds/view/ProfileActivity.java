package com.chiriyankandath.englishvowelssounds.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.chiriyankandath.englishvowelssounds.R;
import com.chiriyankandath.englishvowelssounds.manager.ProfileManager;
import com.chiriyankandath.englishvowelssounds.util.NavigationHelper;

/**
 * Created by puannjoy on 1/13/2016.
 */
public class ProfileActivity extends AppCompatActivity {
	private EditText nameField;
	private EditText ageField;
	private RadioGroup genderField;
	private Button save;
	private TextView topScore;
	ProfileManager profileManager;
	NavigationHelper navigationHelper;

	public void onCreate(Bundle onSavedInstanceState){
		super.onCreate(onSavedInstanceState);
		setContentView(R.layout.profile_activity);
		profileManager = new ProfileManager(this);
		navigationHelper = new NavigationHelper(this);
		nameField =(EditText) findViewById(R.id.profile_name);
		ageField = (EditText) findViewById(R.id.profile_age);
		genderField = (RadioGroup) findViewById(R.id.profile_radio_gender);
		save = (Button) findViewById(R.id.profile_save_button);
		topScore = (TextView) findViewById(R.id.profile_top_score);
		save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int radioButtonID = genderField.getCheckedRadioButtonId();
				View radioButton = genderField.findViewById(radioButtonID);
				int genderIndex = genderField.indexOfChild(radioButton);
				profileManager.setProfileData(nameField.getText(),ageField.getText(),genderIndex);
				navigationHelper.startEnglishQuestionActivity();
				finish();
			}
		});
	}

	@Override
	public void onResume(){
		super.onResume();
		System.out.println("Punnya,: " + profileManager.isProfileCreated() + " : " + profileManager.getProfileName());
		nameField.setText(profileManager.getProfileName());
		ageField.setText(profileManager.getProfileAge());
		RadioButton genderButton = (RadioButton)  (genderField.getChildAt(profileManager.getProfileGender()));
		genderButton.setChecked(true);
		topScore.setText(String.valueOf(profileManager.getProfileTopScore()));


	}

	@Override
	public void onBackPressed(){
		navigationHelper.startEnglishQuestionActivity();
		finish();
	}


}
