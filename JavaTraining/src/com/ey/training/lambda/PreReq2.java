package com.ey.training.lambda;

interface Greeting {
	void greet();
}

//a normal class implementing Greeting interface
class Hello implements Greeting {
	
	@Override
	public void greet() {
		System.out.println("Hello");
	}
}
public class PreReq2 {

	public static void main(String[] args) {
		Greeting g1 = new Hello();
		g1.greet();
		
		//inner class implementing Greeting interface
		class Hi implements Greeting {
			
			@Override
			public void greet() {
				System.out.println("Hi");
			}
		}
		
		Greeting g2 = new Hi();
		g2.greet();
		
		//anonymous class implementing Greeting interface
		Greeting g3 = new Greeting() {

			@Override
			public void greet() {
				System.out.println("Namaste");
			}
		};
		g3.greet();
		
		
	}
}
