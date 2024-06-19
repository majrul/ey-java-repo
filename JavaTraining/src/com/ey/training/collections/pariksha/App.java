package com.ey.training.collections.pariksha;

import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		QuestionBankLoader qbLoader = new QuestionBankLoader();
		List<Question> questions = qbLoader.loadQuestionsOnHTML();
		Scanner s = new Scanner(System.in);
		
		System.out.println("Welcome to Pariskha app v1.0");
		System.out.println("Press any key to start the exam..");
		s.nextLine();
		
		int score = 0;
		for(int i=0; i<questions.size(); i++) {
			Question q = questions.get(i);
			System.out.println("\nQuestion No. " + (i+1) + ")\n" + q.getQuestion());
			
			List<Option> options = q.getOptions();
			for(int j=0; j<options.size(); j++) {
				Option opt = options.get(j);
				System.out.println((j+1) + ". " + opt.getOption());
			}
			
			System.out.println();
			System.out.println("Enter right answer");
			int ans = Integer.parseInt(s.nextLine());
			
			Option selectedOption = options.get(ans - 1);
			if(selectedOption.isRightAnswer())
				score ++;
		}
		
		System.out.println("\nCongratulations, you have scored " + score + " marks");
	}
}
