package com.ey.training.db;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//public interface ProductRepository extends CrudRepository<Product, Integer> {
public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findByPriceGreaterThan(double price);
	public Optional<Product> findByName(String name);
}
