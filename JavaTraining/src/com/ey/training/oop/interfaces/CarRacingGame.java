package com.ey.training.oop.interfaces;

public class CarRacingGame implements MobileApp {

	@Override
	public void start() {
		System.out.println("CarRacingGame start..");
	}

	@Override
	public void pause() {
		System.out.println("CarRacingGame pause..");		
	}

	@Override
	public void stop() {
		System.out.println("CarRacingGame stop..");
	}

}
