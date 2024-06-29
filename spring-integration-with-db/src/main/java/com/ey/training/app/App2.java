package com.ey.training.app;

import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ey.training.db.Product;
import com.ey.training.db.ProductInventory;
import com.ey.training.db.ProductRepository;

public class App2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		ProductRepository prodRepo = ctx.getBean(ProductRepository.class);
		//System.out.println(prodRepo.getClass());
		/*Product product = new Product();
		product.setName("Samsung S24");
		product.setPrice(59000);
		product.setQuantity(50);
		prodRepo.save(product);*/
		
		//List<Product> list = prodRepo.findAll();
		//List<Product> list = prodRepo.findByPriceGreaterThan(50000);
		//List<Product> list = prodRepo.findAllByName("iPhone");
		List<Product> list = prodRepo.findByPrice(49000);
		for(Product product : list)
			System.out.println(product);
		
		/*System.out.println("----------");
		prodRepo
			.findByName("Samsung S24")
			.ifPresent(p -> System.out.println(p));*/
	}
}
