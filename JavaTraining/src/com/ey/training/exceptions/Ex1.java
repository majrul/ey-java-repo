package com.ey.training.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter your age");
		int age = s.nextInt();
		
		System.out.println("Your age is " + age);
		
		/*try {
			System.out.println("Enter your age");
			int age = s.nextInt();
			System.out.println("Your age is " + age);
		}
		catch (InputMismatchException e) {
			System.out.println("You have entered incorrect age");
		}*/
		
		try {
			FileReader f = new FileReader("abc.txt");
		}
		catch(FileNotFoundException e) {
			
		}
		
		String str = null;
		if(str != null)
			str.toLowerCase();
		
		
		int[] arr = new int[5];
		if(arr.length == 11)
			arr[10] = 100;
	}
}
