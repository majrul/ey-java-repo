package com.ey.training.threading;

public class Example1 {

	public static void main(String[] args) {

		class Task1 implements Runnable {
			@Override
			public void run() {
				for(int i=0; i<9999999; i++)
					System.out.println("i is " + i);
			}
		}
		class Task2 implements Runnable {
			@Override
			public void run() {
				for(int j=0; j<9999999; j++)
					System.out.println("j is " + j);
			}
		}
		
		Thread th1 = new Thread(new Task1());
		th1.setPriority(Thread.MAX_PRIORITY);
		Thread th2 = new Thread(new Task2());
		th2.setPriority(Thread.MIN_PRIORITY);
		
		th1.start();
		th2.start();
		

	}
}
