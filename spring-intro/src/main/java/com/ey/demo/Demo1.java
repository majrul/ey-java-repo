package com.ey.demo;

import java.time.LocalTime;

class Greeting {
	
	void greet() {
		LocalTime time = LocalTime.now(); //the problem is here. can we say this is a dependency?
		if(time.getHour() >=5 && time.getHour() < 12)
			System.out.println("Good Morning!");
		else if(time.getHour() >=12 && time.getHour() < 16)
			System.out.println("Good Afternoon!");
		else if(time.getHour() >=16 && time.getHour() < 21)
			System.out.println("Good Evening!");
		else
			System.out.println("Good Night!");
	}
}

public class Demo1 {

	public static void main(String[] args) {
		//this code is difficult to test
		Greeting g = new Greeting();
		g.greet();
	}
}
