package com.ey.training.oop.interfaces;

public class BankingApp implements MobileApp {

	@Override
	public void start() {
		System.out.println("BankingApp start..");
	}

	@Override
	public void pause() {
		System.out.println("BankingApp pause..");		
	}

	@Override
	public void stop() {
		System.out.println("BankingApp stop..");
	}

}
