package com.chiriyankandath.englishvowelssounds.model;

import com.chiriyankandath.englishvowelssounds.manager.QuestionAndAnswer;
import com.chiriyankandath.englishvowelssounds.util.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by puannjoy on 9/5/2015.
 */
public class MalayalamQuestionGenerator {



	private int count = 20;

	public ArrayList<QuestionAndAnswer> questionList = new ArrayList<QuestionAndAnswer>(count);
	HashMap<String,Integer> Questions = new HashMap<>();
	Random random = new Random();
	private static MalayalamQuestionGenerator instance;

	private MalayalamQuestionGenerator() {
		init();
	}

	public static MalayalamQuestionGenerator createQuestionGenerator() {
		if (instance == null) {
			System.out.println("Instance is null");
			instance = new MalayalamQuestionGenerator();
		}
		System.out.println("Instance : "+instance);
		return instance;
	}


	public void init(){
		/*Questions.put("cat",Constants.SHORT_A_SOUND);
		Questions.put("cake",Constants.LONG_A_SOUND);
		Questions.put("eat",Constants.LONG_E_SOUND);
		Questions.put("bed",Constants.SHORT_E_SOUND);
		Questions.put("pin",Constants.SHORT_I_SOUND);
		Questions.put("line",Constants.LONG_I_SOUND);
		Questions.put("rake",Constants.LONG_A_SOUND);
		Questions.put("pot", Constants.SHORT_O_SOUND);
		Questions.put("go",Constants.LONG_O_SOUND);
		Questions.put("cup", Constants.SHORT_U_SOUND);
		Questions.put("cube",Constants.LONG_U_SOUND);
		*/
	/*	if(questionList != null){
			System.out.println("QuestionList is already created and size is: "+ questionList.size());
			return ;
		}*/
		QuestionAndAnswer question1 = new QuestionAndAnswer("cat", Constants.SHORT_A_SOUND,new String ("\u0103".getBytes()),1);
		questionList.add(question1);
		QuestionAndAnswer question2 = new QuestionAndAnswer("cake",Constants.LONG_A_SOUND,new String ("\u0101".getBytes()),1);
		questionList.add(question2);
		QuestionAndAnswer question3 = new QuestionAndAnswer("eat",Constants.LONG_E_SOUND,new String ("\u0113".getBytes()),1);
		questionList.add(question3);
		QuestionAndAnswer question4 = new QuestionAndAnswer("bed",Constants.SHORT_E_SOUND,new String ("\u0115".getBytes()),1);
		questionList.add(question4);
		QuestionAndAnswer question5 = new QuestionAndAnswer("pin",Constants.SHORT_I_SOUND,new String ("\u012D".getBytes()),1);
		questionList.add(question5);
		QuestionAndAnswer question6 = new QuestionAndAnswer("line",Constants.LONG_I_SOUND,new String ("\u012B".getBytes()),1);
		questionList.add(question6);
		QuestionAndAnswer question7 = new QuestionAndAnswer("rake",Constants.LONG_A_SOUND,new String ("\u0101".getBytes()),1);
		questionList.add(question7);
		QuestionAndAnswer question8 = new QuestionAndAnswer("four",Constants.LONG_O_SOUND,new String ("\u014D".getBytes()),1);
		questionList.add(question8);
		QuestionAndAnswer question9 = new QuestionAndAnswer("five",Constants.LONG_I_SOUND,new String ("\u012B".getBytes()),1);
		questionList.add(question9);
		QuestionAndAnswer question10 = new QuestionAndAnswer("your",Constants.LONG_O_SOUND,new String ("\u014D".getBytes()),1);
		questionList.add(question10);
		QuestionAndAnswer question11 = new QuestionAndAnswer("seven",Constants.SHORT_E_SOUND,new String ("\u0115".getBytes()),1);
		questionList.add(question11);
		QuestionAndAnswer question12 = new QuestionAndAnswer("nine",Constants.LONG_I_SOUND,new String ("\u012B".getBytes()),1);
		questionList.add(question12);
		QuestionAndAnswer question13 = new QuestionAndAnswer("map",Constants.SHORT_A_SOUND,new String ("\u0103".getBytes()),1);
		questionList.add(question13);
		QuestionAndAnswer question14 = new QuestionAndAnswer("yes",Constants.SHORT_E_SOUND,new String ("\u0115".getBytes()),1);
		questionList.add(question14);
		QuestionAndAnswer question15 = new QuestionAndAnswer("in",Constants.SHORT_I_SOUND,new String ("\u012D".getBytes()),1);
		questionList.add(question15);
		QuestionAndAnswer question16 = new QuestionAndAnswer("stop",Constants.SHORT_O_SOUND,new String ("\u014F".getBytes()),1);
		questionList.add(question16);
		QuestionAndAnswer question17 = new QuestionAndAnswer("go",Constants.LONG_O_SOUND,new String ("\u014D".getBytes()),1);
		questionList.add(question17);
		QuestionAndAnswer question18 = new QuestionAndAnswer("she",Constants.LONG_E_SOUND,new String ("\u0113".getBytes()),1);
		questionList.add(question18);
		QuestionAndAnswer question19 = new QuestionAndAnswer("by",Constants.LONG_I_SOUND,new String ("\u012B".getBytes()),1);
		questionList.add(question19);
		QuestionAndAnswer question20 = new QuestionAndAnswer("cube",Constants.LONG_U_SOUND,new String ("\u016B".getBytes()),1);
		questionList.add(question20);
		QuestionAndAnswer question21 = new QuestionAndAnswer("cub",Constants.SHORT_U_SOUND,new String ("\u016D".getBytes()),1);
		questionList.add(question21);

		System.out.println("QuestionList is not already created and size is: " + questionList.size());

	}

	public ArrayList getQuestionList(){
		return questionList;
	}

	public QuestionAndAnswer getQuestions() {
		return questionList.get(random.nextInt(21));
	}
}
