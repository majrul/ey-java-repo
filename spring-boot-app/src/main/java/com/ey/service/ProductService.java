package com.ey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ey.entity.Product;
import com.ey.exception.ProductException;
import com.ey.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public void add(Product product) {
		if(productRepository.checkIfProductExists(product.getName()) == 1)
			throw new ProductException("Product already exists!");
		else
			productRepository.save(product);
	}
	
	@Cacheable("productData") //region
	public List<Product> getAll() {
		return productRepository.findAll();
	}
	
	public Product get(int id) {
		return productRepository.findById(id).get();
	}
}
