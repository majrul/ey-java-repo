package com.ey.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ey.entity.Product;

//public interface ProductRepository extends CrudRepository<Product, Integer> {
public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findByPriceGreaterThan(double price);
	public Optional<Product> findByName(String name);
	
	@Query("select p from Product p where p.name like %?1%")
	public List<Product> findAllByName(String name);
	
	@Query("select p from Product p where p.price >= ?1")
	public List<Product> findByPrice(double price);
	
	@Query("select count(p) from Product p where p.name = ?1")
	public Long checkIfProductExists(String name);
}
