package com.ey.training.threading;

import java.util.concurrent.CountDownLatch;

public class Example5 {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2);
		
		Runnable r1 = () -> {
			System.out.println("hello");
			latch.countDown();
		};

		Runnable r2 = () -> {
			System.out.println("hi");
			latch.countDown();
		};

		Runnable r3 = () -> {
			try { latch.await(); } catch (InterruptedException e) { }
			System.out.println("welcome");
		};

		new Thread(r3).start();
		new Thread(r1).start();
		new Thread(r2).start();
	}
}
