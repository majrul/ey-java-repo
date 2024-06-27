package com.ey.training.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ey.training.db.Product;
import com.ey.training.db.ProductInventory;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		ProductInventory prodInv = (ProductInventory) ctx.getBean("prodInv1");
		
		Product product = new Product();
		product.setName("iPhone XR");
		product.setPrice(29000);
		product.setQuantity(99);
		prodInv.add(product);
	}
}
