package com.ey.training.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("prodInv4")
public class ProductInventoryImpl4 implements ProductInventory {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void add(Product product) {
		entityManager.persist(product);
	}

	@Override
	public List<Product> getAvailableProducts() {
		return entityManager
				.createQuery("select p from Product p") //HQL/JPQL
				.getResultList();
	}

}
