package com.ey.training.oop.copy.copy;

public abstract class Product /*extends Object*/ {

	//class variable(s)
	private static int generator = 1000;
	
	//instance variable(s)
	private int id;
	private String name;
	//private String type;
	private String description;
	private double price;
	private int stockInHand;
	
	//constructor(s)
	//in eclipse, we can generate constructor
	//menu bar->source->generate constr. using fields
	//default constructor
	public Product() {
		this.id = ++generator;		
	}
	
	public Product(String name, double price, int stockInHand) {
		this.id = ++generator;
		this.name = name;
		this.price = price;
		this.stockInHand = stockInHand;
	}
	
	//we use getters and setters for read/write operations
	//in eclipse, we can generate getters and setters
	//menu bar->source->generate getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockInHand() {
		return stockInHand;
	}

	public void setStockInHand(int stockInHand) {
		this.stockInHand = stockInHand;
	}

	public int getId() {
		return id;
	}
	
	public abstract double calculateDiscount();
		

	public void info() {
		System.out.println("----------------");
		System.out.println("ID >> " + id);
		System.out.println("Name >> " + name);
		System.out.println("Description >> " + description);
		System.out.println("Price >> " + price);
		System.out.println("Stock In Hand >> " + stockInHand);
	}
}
