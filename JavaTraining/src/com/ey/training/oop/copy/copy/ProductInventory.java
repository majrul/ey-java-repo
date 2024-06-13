package com.ey.training.oop.copy.copy;

public class ProductInventory {

	private Product[] products = new Product[4];
	private int index;
	
	public void add(Product product) {
		products[index++] = product;
	}
	
	public double placeOrder(String name, int quantity) {
		double billAmount = 0;
		for(int i=0; i<products.length; i++) {
			Product product = products[i];
			if(product.getName() == name) {
				double discount = product.calculateDiscount();
				billAmount = (product.getPrice() - discount) * quantity;
				break;
			}
		}
		return billAmount;
	}
}
