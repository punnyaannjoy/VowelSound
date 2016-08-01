package com.chiriyankandath.englishvowelssounds.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.chiriyankandath.englishvowelssounds.R;
import com.chiriyankandath.englishvowelssounds.manager.ProfileManager;
import com.chiriyankandath.englishvowelssounds.util.NavigationHelper;

/**
 * Created by puannjoy on 1/6/2016.
 */
public class SplashActivity extends Activity {

	private static final long NEXT_ACTIVITY_DELAY = 2000;
	NavigationHelper navigationHelper;
	ProfileManager profileManager;

	public void onCreate(Bundle onSavedInstanceState){
		super.onCreate(onSavedInstanceState);
		setContentView(R.layout.splash_avtivity);
		navigationHelper = new NavigationHelper(this);
		profileManager = new ProfileManager(this);
		ImageView logo = (ImageView)findViewById(R.id.logo);
		logo.postDelayed(new Runnable() {
			@Override
			public void run() {
				startNextActivity();
			}
		}, NEXT_ACTIVITY_DELAY);

	}


	private void startNextActivity(){

		if(profileManager.isProfileCreated()) {
			navigationHelper.startSelectSubjectActivity();
			finish();
		} else {
			System.out.println("Punnya profile is not created");
			navigationHelper.startProfileActivity();
			finish();
		}

	}

}
