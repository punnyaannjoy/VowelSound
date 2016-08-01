package com.chiriyankandath.englishvowelssounds.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.media.VolumeProviderCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.chiriyankandath.englishvowelssounds.manager.QuestionAndAnswer;
import com.chiriyankandath.englishvowelssounds.model.QuestionGenerator;
import com.chiriyankandath.englishvowelssounds.R;
import com.chiriyankandath.englishvowelssounds.manager.ScoreManager;
import com.chiriyankandath.englishvowelssounds.util.ActivityNotFinishing;
import com.chiriyankandath.englishvowelssounds.util.NavigationHelper;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A placeholder fragment containing a simple view.
 */

public class VowelQuestionActivityFragment extends Fragment {
	
	View view;
	TextView skipButton;
	TextSwitcher question;
	Button option1;
	Button option2;
	Button option3;
	Button option4;
	String answer;
	LinearLayout optionList;
	private int count=1;

	QuestionAndAnswer questionAndAnswer;
	ScoreManager scoreManager;
	NavigationHelper navigationHelperActivity;

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		System.out.println("Punnya : onAttach Fragment");

	}


	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		System.out.println("Punnya : onPrepareOptionMenu Fragment");

		super.onPrepareOptionsMenu(menu);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public void onStop() {
		System.out.println("Punnya : onStop Fragment");

		super.onStop();
	}

	@Override
	public void onPause() {
		System.out.println("Punnya : onPause Fragment");

		super.onPause();
	}

	@Override
	public void onStart() {
		System.out.println("Punnya : onStart Fragment");

		super.onStart();
	}

	@Override
	public void onDestroy() {
		System.out.println("Punnya : onDestroy Fragment");

		super.onDestroy();
	}

	@Override
	public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
		System.out.println("Punnya : onViewStateRestored Fragment");

		super.onViewStateRestored(savedInstanceState);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		System.out.println("Punnya : onSaveInstanceState Fragment");

		super.onSaveInstanceState(outState);
	}

	@Override
	@ActivityNotFinishing(isFinishing = true)
	public void onCreate(Bundle saveInstanceState){
		System.out.println("Punnya : onCreate Fragment");
		setHasOptionsMenu(true);
		super.onCreate(saveInstanceState);
		scoreManager = new ScoreManager();
		navigationHelperActivity = new NavigationHelper(this.getActivity());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		System.out.println("Punnya : onCreateView Fragment");

		view = inflater.inflate(R.layout.fragment_vowel_question, container, false);
		//updateQuestions();
		return view;
	}
	@Override
	public void onViewCreated(View view,Bundle savedInstanceState){
		System.out.println("Punnya : onViewCreated Fragment");

		skipButton = (TextView) view.findViewById(R.id.skip);
		question = (TextSwitcher) view.findViewById(R.id.questions_field);
		optionList = (LinearLayout)view.findViewById(R.id.options);

		question.setFactory(new ViewSwitcher.ViewFactory() {
			@Override
			public View makeView() {
				TextView t = new TextView(getContext());
				t.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);
				t.setTextSize(40);
				t.setTextColor(Color.BLACK);
				return t;
			}
		});
		/*question.addView(new TextView(this.getContext()));
		question.addView(new TextView(this.getContext()));*/

		question.setInAnimation(this.getContext(),android.R.anim.fade_in);
		question.setOutAnimation(this.getContext(), android.R.anim.fade_out);

		option1 = (Button) view.findViewById(R.id.answer1);
		option2 = (Button) view.findViewById(R.id.answer2);
		option3 = (Button) view.findViewById(R.id.answer3);
		option4 = (Button) view.findViewById(R.id.answer4);
		updateQuestions();
	}

	@Override
	public void onResume(){
		System.out.println("Punnya : onResume Fragment");

		super.onResume();

		//updateQuestions();


	}

	public void updateQuestions(){
		questionAndAnswer = QuestionGenerator.createQuestionGenerator().getQuestions();
		question.setBackgroundColor(getActivity().getResources().getColor(android.R.color.white));
		optionList.setVisibility(View.VISIBLE);
		System.out.println("Punnya : the question is : " + questionAndAnswer.getQuestion());
		question.setText(questionAndAnswer.getQuestion());
		answer = questionAndAnswer.getVowel();
		System.out.println(" Punnya : correct Answer is :" + answer);
		ArrayList<String> optionsList = generateOptionList(answer);
		int startNumber = new Random().nextInt(6);

		List<String> subList = optionsList.subList(startNumber,startNumber+3);
		subList.add(new Random().nextInt(3), answer);

		for(int i= 0; i< 4; i++){
			Button answerOption = (Button) optionList.getChildAt(i);
			answerOption.setText(subList.get(i));
		}
		setupClickListener(answer);
	}

	public void setupClickListener(final String answer){
		skipButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				updateQuestions();
			}
		});
		View.OnClickListener clickListener = getButtonListener(answer);
		option1.setOnClickListener(clickListener);
		option2.setOnClickListener(clickListener);

		option3.setOnClickListener(clickListener);
		option4.setOnClickListener(clickListener);

	}

	@NonNull
	private View.OnClickListener getButtonListener(final String answer) {
		return new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Button button = (Button)v;
				System.out.println("Punnya : button text: "+button.getText());
				if(button.getText().toString().equals(answer)){
					System.out.println("Punnya : answer is correct");
					updateAnimation(true);
					scoreManager.calculateScore(questionAndAnswer);
				}
				else {
					updateAnimation(false);
					questionAndAnswer.setAttempt(questionAndAnswer.getAttempt() + 1);
				}
			}
		};
	}

	private void updateAnimation(boolean status){
		if(status){
			question.setBackgroundColor(getActivity().getResources().getColor(android.R.color.holo_green_dark));
			question.postDelayed(nextQuestion(), 2000);
		} else  {
			question.setBackgroundColor(getActivity().getResources().getColor(android.R.color.holo_red_dark));

		}
	}


	private Runnable nextQuestion(){
					 return new Runnable() {
						@Override
						public void run() {
							if(navigationHelperActivity.continueQuestion()){
								updateQuestions();
							} else {
								navigationHelperActivity.startScoreActivity(scoreManager);
								getActivity().finish();
							}
						}
					};

	}

	public ArrayList generateOptionList(String answer){
		System.out.println("Punnya answer : " + answer);
		ArrayList optionList = new ArrayList();
		optionList.add(new String("\u0103".getBytes()));
		optionList.add(new String ("\u0101".getBytes()));
		optionList.add(new String ("\u0115".getBytes()));
		optionList.add(new String ("\u0113".getBytes()));
		optionList.add(new String ("\u012D".getBytes()));
		optionList.add(new String ("\u012B".getBytes()));
		optionList.add(new String ("\u014F".getBytes()));
		optionList.add(new String ("\u014D".getBytes()));
		optionList.add(new String ("\u016D".getBytes()));
		optionList.add(new String ("\u016B".getBytes()));
		System.out.println("Punnya the optionList : " +optionList);

		int answerIndex = optionList.indexOf(answer);
		System.out.println("Punnya index : "+answerIndex);
		optionList.remove(answerIndex);
		return optionList;
	}


	public String getOtherOptions(String answer, Random options){
		int optionIndex = options.nextInt(7)+1;

		String option = ((QuestionAndAnswer) QuestionGenerator.createQuestionGenerator().getQuestionList().get(optionIndex)).getVowel();
		System.out.println("PUnnya : the answer at index : "+optionIndex+ " answer is: "+ option);


		if(option.equals( answer)){
			optionIndex = options.nextInt(7)+1;
			option = ((QuestionAndAnswer) QuestionGenerator.createQuestionGenerator().getQuestionList().get(optionIndex)).getVowel();;
			System.out.println("PUnnya : optin same as answer, changing itat index : "+optionIndex+ " answer is: "+ option);

		}
		return option;
	}
}
