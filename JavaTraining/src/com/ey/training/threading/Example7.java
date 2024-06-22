package com.ey.training.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example7 {

	public static void main(String[] args) {
		ExecutorService execService = Executors.newFixedThreadPool(2); //worker threads
		//new Thread().start(); --> green threads (thread is created, memory and cpu resource allocated, thread is executed, thread is destroyed)

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
		
		execService.execute(new Task1());
		execService.execute(new Task2());

		/*Thread th = new Thread();
		th.start();
		System.out.println(th.getState());
		try { Thread.sleep(5000); } catch(Exception e) { }
		System.out.println(th.getState());
		th.start();*/
	}
}
