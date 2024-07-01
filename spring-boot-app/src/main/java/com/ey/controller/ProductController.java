package com.ey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ey.dto.Status;
import com.ey.entity.Product;
import com.ey.exception.ProductException;
import com.ey.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/product/all")
	public List<Product> all() {
		return productService.getAll();
	}
	
	@GetMapping("/product/{id}")
	public Product fetch(@PathVariable int id) {
		return productService.get(id);
	}
	
	@PostMapping("/product/add")
	public Status add(@RequestBody Product product) {
		//productService.add(product);
		//return "Product added!";
		Status status = new Status();
		try {
			productService.add(product);
			status.setStatus(true);
			status.setMessageIfAny("Product added!");
			return status;
		}
		catch (ProductException e) {
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return status;
		}
	}
}
