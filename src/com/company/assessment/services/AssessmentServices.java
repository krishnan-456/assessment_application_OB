package com.company.assessment.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.company.assessment.data.ProgressData;
import com.company.assessment.data.QuestionsData;
import com.company.assessment.data.UserData;

public class AssessmentServices {
	static ArrayList<UserData> users;
	public static LinkedList<QuestionsData> questions;
	static HashMap<Integer, String> answers;
	static ArrayList<ProgressData> progress = new ArrayList<>();

	static {
		users = new ArrayList<>();
		users.add(new UserData("Krishna", "Krish@456", "Krishnan K"));
		users.add(new UserData("Nasim", "Nasim123", "Mohamed Nasim"));
	}

	static {
		questions = new LinkedList<>();
		answers = new HashMap<>();
		answers.put(1, "Mango");
		answers.put(2, "Apple");
		answers.put(3, "JackFruit");
		answers.put(4, "Banana");
		questions.add(new QuestionsData("What is the national fruit of India? ", answers, 1));
		answers = new HashMap<>();
		answers.put(1, "Lion");
		answers.put(2, "Monkey");
		answers.put(3, "Tiger");
		answers.put(4, "leopard");
		questions.add(new QuestionsData("What is the national animal of India? ", answers, 3));
		answers = new HashMap<>();
		answers.put(1, "Nehru");
		answers.put(2, "Mahatma Gandhi");
		answers.put(3, "Narendra Modi");
		answers.put(4, "Subhash chandra bose");
		questions.add(new QuestionsData("Who is father of nation? ", answers, 2));
		answers = new HashMap<>();
		answers.put(1, "1880");
		answers.put(2, "1947");
		answers.put(3, "1990");
		answers.put(4, "1946");
		questions.add(new QuestionsData("When India got Freedom ", answers, 2));
		answers = new HashMap<>();
		answers.put(1, "World Health Organization");
		answers.put(2, "World Heart Organization");
		answers.put(3, "World Health Organisation");
		answers.put(4, "Web Hook Organization");
		questions.add(new QuestionsData("What is the national animal of India? ", answers, 1));
	}

	public boolean checkIfUserExist(String userName) {
		for (UserData user : users) {
			if (user.getUserName().equals(userName)) {
				return true;
			}
		}
		return false;
	}

	public boolean userRegisteration(String userName, String password, String fullName) {
		if (checkIfUserExist(userName)) {
			return false;
		} else {
			users.add(new UserData(userName, password, fullName));
			return true;
		}
	}

	public boolean userLogin(String userName, String password) {
		if (checkIfUserExist(userName)) {
			for (UserData user : users) {
				if (user.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

	public UserData returnUserData(String userName) {
		if (checkIfUserExist(userName)) {
			for (UserData user : users) {
				if (user.getUserName().equals(userName)) {
					return user;
				}
			}
		}
		return null;
	}

	public LinkedList<QuestionsData> getQuestions() {
		return questions;
	}

	public void addProgess(String userName, String fullName, int totalCorrect, int totalInCorrect, int awardedMarks) {
		progress.add(new ProgressData(userName, fullName, totalCorrect, totalInCorrect, totalCorrect * 2));
	}

	public void returnProgress() {
		for (ProgressData result : progress) {
			if(result != null) {
				System.out.printf("| %-6s | %-12s | %-18s | %-18s | %-6s |%n", "UserName", "FullName", "TotalCorrectAnswers",
						"TotalInCorrectAnswers", "TotalScore");
				System.out.printf("| %-8s | %-12s | %-19s | %-21s | %-10s |%n", result.getUserName(), result.getFullName(),
						result.getTotalCorrect(), result.getTotalInCorrect(), result.getAwardedMarks());
				break;
			
			}
			System.err.println("No score captured... Attend the test...");
		}
	}

}
