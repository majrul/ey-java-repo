package com.ey.training.oop;

public class Toy extends Product {

	private AgeGroup ageGroup;

	public Toy(String name, double price, int stockInHand, AgeGroup ageGroup) {
		super(name, price, stockInHand);
		this.ageGroup = ageGroup;
	}

	public AgeGroup getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}

}
