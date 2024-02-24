package com.company.assessment.data;

public class ProgressData {
	private String userName;
	private String fullName;
	private int totalCorrect;
	private int totalInCorrect;
	private int awardedMarks;
	
	public ProgressData(String userName, String fullName, int totalCorrect, int totalInCorrect, int awardedMarks) {
		this.userName = userName;
		this.fullName = fullName;
		this.totalCorrect = totalCorrect;
		this.totalInCorrect = totalInCorrect;
		this.awardedMarks = awardedMarks;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getTotalCorrect() {
		return totalCorrect;
	}

	public void setTotalCorrect(int totalCorrect) {
		this.totalCorrect = totalCorrect;
	}

	public int getTotalInCorrect() {
		return totalInCorrect;
	}

	public void setTotalInCorrect(int totalInCorrect) {
		this.totalInCorrect = totalInCorrect;
	}

	public int getAwardedMarks() {
		return awardedMarks;
	}

	public void setAwardedMarks(int awardedMarks) {
		this.awardedMarks = awardedMarks;
	}
	
	
	
	
}
