package com.ey.training.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		/*System.out.println("Enter your age");
		int age = s.nextInt();
		
		System.out.println("Your age is " + age);*/
		
		try {
			System.out.println("Enter your age");
			int age = s.nextInt();
			System.out.println("Your age is " + age);
		}
		catch (InputMismatchException e) {
			System.out.println("You have entered incorrect age");
		}
		
	}
}
