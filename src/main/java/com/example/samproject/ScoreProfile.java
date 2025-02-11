package com.example.samproject;

public class ScoreProfile {


	private int score;
	private int firstPlaceCount;
	private int secondPlaceCount;
	private int thirdPlaceCount;
	
	public ScoreProfile() {
		this.score = 0;
		this.firstPlaceCount = 0;
		this.secondPlaceCount = 0;
		this.thirdPlaceCount = 0;
	}

	public int getScore() {
		return score;
	}

	public void addScore(int score) {
		this.score += score;
	}

	public int getFirstPlaceCount() {
		return firstPlaceCount;
	}

	public void addFirstPlaceCount() {
		this.firstPlaceCount++;
	}

	public int getSecondPlaceCount() {
		return secondPlaceCount;
	}

	public void addSecondPlaceCount() {
		this.secondPlaceCount++;
	}

	public int getThirdPlaceCount() {
		return thirdPlaceCount;
	}

	public void addThirdPlaceCount() {
		this.thirdPlaceCount++;
	}
}
