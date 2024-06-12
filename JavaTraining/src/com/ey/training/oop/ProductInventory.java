package com.ey.training.oop;

public class ProductInventory {

	private Product[] products = new Product[4];
	private int index;
	
	public void add(Product product) {
		products[index++] = product;
	}
	
	public double calculateDiscount(Product product) {
		double discount = 0;
		if(product instanceof Book)
			discount = product.getPrice() * 0.10;
		else if(product instanceof Toy) {
			Toy toy = (Toy) product;
			if(toy.getAgeGroup() == AgeGroup.TWO_FOUR)
				discount = product.getPrice() * 0.15;
			else if(toy.getAgeGroup() == AgeGroup.FOUR_FIVE)
				discount = product.getPrice() * 0.05;
		}
		return discount;
	}
	
	public double placeOrder(String name, int quantity) {
		double billAmount = 0;
		for(int i=0; i<products.length; i++) {
			Product product = products[i];
			if(product.getName() == name) {
				double discount = calculateDiscount(product);
				billAmount = (product.getPrice() - discount) * quantity;
				break;
			}
		}
		return billAmount;
	}
}
