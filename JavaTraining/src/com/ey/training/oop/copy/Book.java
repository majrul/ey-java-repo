package com.ey.training.oop.copy;

public class Book extends Product {

	private int isbn;

	public Book(String name, double price, int stockInHand, int isbn) {
		super(name, price, stockInHand);
		this.isbn = isbn;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public double calculateDiscount() {
		return getPrice() * 0.10;
	}

	@Override
	public void info() {
		super.info();
		System.out.println("ISBN >> " + isbn);
	}
}
