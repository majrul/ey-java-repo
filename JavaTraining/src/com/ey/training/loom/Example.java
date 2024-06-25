package com.ey.training.loom;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class Example {

	public static void main(String[] args) throws InterruptedException {
		class SomeTask implements Runnable {
			@Override
			public void run() {
				for(int i=0; i<100; i++) {
					try {
						int a = (int)(Math.random() * 100);
						int b = (int)(Math.random() * 100);
						int c = a * b;
						System.out.println("c = " + c);
						Thread.sleep(1000);
					}
					catch (Exception e) {}
				}
			}
		}
		
		for(int i=0; i<1000; i++) {
			//Thread t = new Thread(new SomeTask());
			//t.start();
			Thread.startVirtualThread(new SomeTask());
		}
		
		Thread.sleep(Duration.of(5, ChronoUnit.MINUTES));
	}
}
