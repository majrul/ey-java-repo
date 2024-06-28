package com.ey.training.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ey.training.db.Product;
import com.ey.training.db.ProductInventory;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		ProductInventory prodInv = (ProductInventory) ctx.getBean("prodInv2");
		
		//entity class are not instantiated using Spring directly
		
		/*Product product = new Product();
		product.setName("iPhone XR");
		product.setPrice(29000);
		product.setQuantity(99);
		prodInv.add(product);*/
		
		long ms1 = System.currentTimeMillis();
		List<Product> list = prodInv.getAvailableProducts();
		long ms2 = System.currentTimeMillis();
		System.out.println("approx time taken to fetch data from db " + (ms2 - ms1) + " ms");

		/*for(Product product : list)
			System.out.println(product);*/
	}
}
