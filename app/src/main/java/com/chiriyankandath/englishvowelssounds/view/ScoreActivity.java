package com.chiriyankandath.englishvowelssounds.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chiriyankandath.englishvowelssounds.R;
import com.chiriyankandath.englishvowelssounds.manager.ProfileManager;
import com.chiriyankandath.englishvowelssounds.util.NavigationHelper;

/**
 * Created by puannjoy on 1/13/2016.
 */
public class ScoreActivity extends AppCompatActivity {
	int score;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score_activity);

		int score = getIntent().getIntExtra("SCORE",0);//savedInstanceState.getInt("SCORE",0);
		TextView scoreview = (TextView) findViewById(R.id.score);
		scoreview.setText("Your score is : "+score);
		Button continueButton = (Button) findViewById(R.id.continue_button);
		TextView close = (TextView) findViewById(R.id.close);
		ProfileManager profileManager = new ProfileManager(this);
		if(score > profileManager.getProfileTopScore()){
			profileManager.updateScore(score);
		}
		continueButton.setOnTouchListener(getContinueTextTouchListener());
		close.setOnTouchListener(getCloseTextTouchListener());
	}

	@NonNull
	private View.OnTouchListener getCloseTextTouchListener() {
		final NavigationHelper navigationHelper = new NavigationHelper(this);

		return new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				finish();
				//navigationHelper.AppExit();
				return false;
			}
		};
	}

	private View.OnTouchListener getContinueTextTouchListener() {
		final NavigationHelper navigationHelper = new NavigationHelper(this);

		return new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				finish();
				navigationHelper.startEnglishQuestionActivity();
				return false;
			}
		};
	}

	/*public View.OnClickListener getContinueButtonClickListener(){
		final NavigationHelper navigationHelper = new NavigationHelper(this);

		return (new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				navigationHelper.startEnglishQuestionActivity();
			}
		});
	}

	public View.setOnTouchListener getCloseTextClickListener(){
		return (new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}*/

}
