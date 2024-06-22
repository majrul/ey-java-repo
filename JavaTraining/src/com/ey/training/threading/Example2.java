package com.ey.training.threading;

public class Example2 {

	public static void main(String[] args) {

		class Task1 extends Thread {
			@Override
			public void run() {
				for(int i=0; i<9999999; i++) {
					System.out.println("i is " + i);
					//try { Thread.sleep(100); } catch(InterruptedException e) { }
					Thread.yield();
				}
			}
		}
		class Task2 extends Thread {
			@Override
			public void run() {
				for(int j=0; j<9999999; j++) {
					System.out.println("j is " + j);
					//try { Thread.sleep(100); } catch(InterruptedException e) { }
					Thread.yield();
				}
			}
		}
		
		Task1 task1 = new Task1();
		task1.start();

		Task2 task2 = new Task2();
		task2.start();

	}
}
