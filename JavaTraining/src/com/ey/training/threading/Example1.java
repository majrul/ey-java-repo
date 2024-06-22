package com.ey.training.threading;

public class Example1 {

	public static void main(String[] args) {

		class Task1 implements Runnable {
			@Override
			public void run() {
				for(int i=0; i<9999999; i++) {
					System.out.println("i is " + i);
					//try { Thread.sleep(100); } catch(InterruptedException e) { }
					Thread.yield();
				}
			}
		}
		class Task2 implements Runnable {
			@Override
			public void run() {
				for(int j=0; j<9999999; j++) {
					System.out.println("j is " + j);
					//try { Thread.sleep(100); } catch(InterruptedException e) { }
					Thread.yield();
				}
			}
		}
		
		Thread th1 = new Thread(new Task1());
		//th1.setDaemon(true);
		//th1.setPriority(Thread.MAX_PRIORITY);
		Thread th2 = new Thread(new Task2());
		//th2.setDaemon(true);
		//th2.setPriority(Thread.MIN_PRIORITY);
		
		Thread th3 = new Thread(() -> {
			for(int k=0; k<9999999; k++) {
				System.out.println("k is " + k);
				Thread.yield();
			}
		});
		
		th1.start();
		th2.start();
		th3.start();
		
		/*for(int i=0;i<10000;i++)
			System.out.println("main..");*/

	}
}
