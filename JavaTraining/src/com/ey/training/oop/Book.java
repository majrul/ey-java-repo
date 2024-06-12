package com.ey.training.oop;

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

}
