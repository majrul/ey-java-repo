package com.ey.training.oop.copy;

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

	@Override
	public double calculateDiscount() {
		double discount = 0;
		if(getAgeGroup() == AgeGroup.TWO_FOUR)
			discount = getPrice() * 0.15;
		else if(getAgeGroup() == AgeGroup.FOUR_FIVE)
			discount = getPrice() * 0.05;
		return discount;
	}
	
	@Override
	public void info() {
		super.info();
		System.out.println("Age Group >> " + ageGroup);
	}

}
