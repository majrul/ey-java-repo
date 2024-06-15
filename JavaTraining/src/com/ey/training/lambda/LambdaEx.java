package com.ey.training.lambda;

@FunctionalInterface
interface Printer {
	void print(String document);
}

//Write a lambda expression for this Math interface
interface Math {
	int calc(int x, int y);
}

interface Calc {
	int calc(int x, int y);
}

class Addition implements Math {
	@Override
	public int calc(int x, int y) {
		return x + y;
	}
}
public class LambdaEx {

	public static void main(String[] args) {
		//anonymous inner class implementing Printer interface
		Printer p1 = new Printer() {
			@Override
			public void print(String document) {
				System.out.println("printing..");
			}
		};
		p1.print("abc.txt");
		
		//lambda expression based implementation of Printer interface
		Printer p2 = (document) -> System.out.println("printing..");
		p2.print("abc.txt");
		
		Calc m  = (x, y) ->  x + y;
		System.out.println(m.calc(100, 200));
	}
}
