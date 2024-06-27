package com.ey.training.db;

import java.util.List;

public interface ProductInventory {

	public void add(Product product);
	public List<Product> getAvailableProducts();
}
