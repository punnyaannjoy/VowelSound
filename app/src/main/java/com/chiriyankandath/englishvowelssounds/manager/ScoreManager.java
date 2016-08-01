package com.chiriyankandath.englishvowelssounds.manager;

/**
 * Created by puannjoy on 1/5/2016.
 */
public class ScoreManager {

	private int FIRST_ATTEMPT_SCORE = 4;
	private int SECOND_ATTEMPT_SCORE = 2;
	private int THIRD_ATTEMPT_SCORE = 1;
	public int score;


	public void calculateScore(QuestionAndAnswer questionAndAnswer){
		int attemptScore;
		switch (questionAndAnswer.getAttempt()){
			case 1 :
				System.out.println("Punnya: first attempt");
				attemptScore = FIRST_ATTEMPT_SCORE;
				break;
			case 2:
				System.out.println("Punnya: second attempt");

				attemptScore = SECOND_ATTEMPT_SCORE;
				break;
			case 3 :
				System.out.println("Punnya: third attempt");

				attemptScore = THIRD_ATTEMPT_SCORE;
				break;
			default :
				System.out.println("Punnya: more than 3 attempt");

				attemptScore = 0;
		}
		score = score + attemptScore;
		System.out.println(" Score : "+score);
	}

	public int getScore(){
		return score;
	}

	public void clearScore(){
		score = 0;
	}
}
