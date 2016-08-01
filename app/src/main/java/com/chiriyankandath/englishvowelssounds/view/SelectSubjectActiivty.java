package com.chiriyankandath.englishvowelssounds.view;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.chiriyankandath.englishvowelssounds.R;
import com.chiriyankandath.englishvowelssounds.util.NavigationHelper;


/**
 * Created by puannjoy on 5/26/2016.
 */
public class SelectSubjectActiivty extends Activity {
	private NavigationHelper navigationHelper;
	private TextView englishLearning;
	private TextView mathLearning;
	private TextView malayalamLearning;
	private TextView exit;
	private View tableView;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_subject_activity);
		navigationHelper = new NavigationHelper(this);
		englishLearning = (TextView) findViewById(R.id.english_learning);
		malayalamLearning = (TextView) findViewById(R.id.malayalam_learning);
		mathLearning = (TextView) findViewById(R.id.math_learning);
		exit = (TextView) findViewById(R.id.exit_app);
		tableView = findViewById(R.id.selection_table);
		englishLearning.setOnClickListener(getClickListener());

	}

	@NonNull
	private View.OnClickListener getClickListener() {
		return new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (v == findViewById(R.id.english_learning)) {
					navigationHelper.startEnglishQuestionActivity();
					return;
				}
				if (v == findViewById(R.id.malayalam_learning)) {
					navigationHelper.startMalayalamLearningActivity();
					return;
				}
				if (v == findViewById(R.id.math_learning)) {
					navigationHelper.startMathLearningActivity();
					return;
				}
				if(v == findViewById(R.id.exit_app)) {
					navigationHelper.AppExit();
					return;
				}
			}
		};
	}


}
