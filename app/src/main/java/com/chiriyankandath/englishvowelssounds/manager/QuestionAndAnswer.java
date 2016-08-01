package com.chiriyankandath.englishvowelssounds.manager;

/**
 * Created by puannjoy on 9/5/2015.
 */
public class QuestionAndAnswer {
	private String question;
	private int answer;
	private String vowel;
	private int attempt;

	public QuestionAndAnswer(String question,int answer, String vowel,int attempt ){
		this.question = question;
		this.answer = answer;
		this.vowel = vowel;
		this.attempt = attempt;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}



	public int getAnswer() {
		return answer;
	}
	public String getVowel(){
		return vowel;
	}
	public int getAttempt(){
		return  attempt;
	}

	public void setAttempt (int attempt){
		this.attempt = attempt;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}


}
