package com.ey.demo;

import java.time.LocalTime;

class Greet {
	
	LocalTime time;
	
	Greet(LocalTime time) { //dependency
		this.time = time;
	}
	
	void greet() {
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

public class Demo2 {

	public static void main(String[] args) {
		//LocalTime time = LocalTime.now();
		LocalTime time = LocalTime.of(8, 30);
		Greet g = new Greet(time);
		g.greet();
	}
}
