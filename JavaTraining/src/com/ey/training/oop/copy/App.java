package com.ey.training.oop.copy;

public class App {

	public static void main(String[] args) {
		ProductInventory inv = new ProductInventory();
		
		Book b1 = new Book("Java Complete Reference", 450, 99, 1234567890);
		Book b2 = new Book("Java Unleashed", 550, 99, 987654321);
	
		Toy t1 = new Toy("RC Car", 1500, 25, AgeGroup.ABOVE_FIVE);
		Toy t2 = new Toy("Lego Blocks", 700, 25, AgeGroup.FOUR_FIVE);

		inv.add(b1);
		inv.add(b2);
		inv.add(t1);
		inv.add(t2);
		
		double billAmount = inv.placeOrder("Lego Blocks", 5);
		System.out.println(billAmount);
		
		b1.info();
		b2.info();
		t1.info();
		t2.info();
	}
}
