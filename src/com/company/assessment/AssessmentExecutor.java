package com.company.assessment;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.company.assessment.data.QuestionsData;
import com.company.assessment.data.UserData;
import com.company.assessment.services.AssessmentServices;

public class AssessmentExecutor {

	public static void main(String[] args) {

		int choice, totalCorrect = 0, totalInCorrect = 0;
		String userName, password, fullName;
		int correctAnswer;
		boolean flag = true;

		Scanner input = new Scanner(System.in);

		AssessmentServices services = new AssessmentServices();
		while (flag) {
			System.out.println("------------------Welcome to Assessment portal------------------");
			System.out.print("1.Login\n2.Register\nEnter your Choice:");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter the userName: ");
				userName = input.next();
				System.out.print("Enter the password: ");
				password = input.next();
				if (services.userLogin(userName, password)) {
					UserData userData = services.returnUserData(userName);
					System.out.println("Login Successfully");
					do {
						System.out.println("----------------Start Assessment----------------");
						System.out.print("1.startTest\n2.showScore\n3.exit\nEnter your choice:");
						choice = input.nextInt();
						switch (choice) {
						case 1:
							for (QuestionsData question : services.getQuestions()) {
								System.out.println(question.getQuestion());
								for (Map.Entry<Integer, String> answer : question.getAnswer().entrySet()) {
									System.out.println(answer);
								}
								System.out.println("Enter the correct option: ");
								correctAnswer = input.nextInt();
								if (correctAnswer == question.getCorrectAnswer()) {
									totalCorrect += 1;
								}
							}
							totalInCorrect = services.questions.size() - totalCorrect;
							System.out.println("Total correct: " + totalCorrect);
							System.out.println("Total inCorrect: " + totalInCorrect);
							System.out.println("Test was successfully done");
							services.addProgess(userName, userData.getFullName(), totalCorrect, totalInCorrect, 0);
							break;
						case 2:
							services.returnProgress();
							break;
						case 3:
							break;
						default:
							System.err.println("Invaild choice");
						}
						System.out.print("Do you want to continue:[y/n]: ");
					} while (input.next().charAt(0) == 'y');
				} else {
					System.err.println("Invaild credentials");
				}
				break;
			case 2:
				System.out.print("Enter the userName: ");
				userName = input.next();
				System.out.print("Enter the password: ");
				password = input.next();
				System.out.print("Enter the fullName: ");
				fullName = input.next();
				if (services.userRegisteration(userName, password, fullName)) {
					System.out.println("user registered successfully");
				} else {
					System.err.println("Registeration failed");
				}
				break;
			default:
				System.err.println("Invaild choice");
			}
		}
	}

}
