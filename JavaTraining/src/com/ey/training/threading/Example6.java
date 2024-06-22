package com.ey.training.threading;

import java.util.concurrent.CyclicBarrier;

public class Example6 {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);
		
		Runnable r1 = () -> {
			System.out.println("hello start");
			try { barrier.await(); } catch(Exception e) { }
			System.out.println("hello end");
		};

		Runnable r2 = () -> {
			System.out.println("hi start");
			try { barrier.await(); } catch(Exception e) { }
			System.out.println("hi end");
		};

		Runnable r3 = () -> {
			System.out.println("welcome start");
			try { Thread.sleep(5000); } catch(Exception e) { }
			try { barrier.await(); } catch(Exception e) { }
			System.out.println("welcome end");
		};

		new Thread(r3).start();
		new Thread(r1).start();
		new Thread(r2).start();
	}
}
