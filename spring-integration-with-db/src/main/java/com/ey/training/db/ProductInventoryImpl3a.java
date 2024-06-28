package com.ey.training.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("prodInv3a")
public class ProductInventoryImpl3a implements ProductInventory {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void add(Product product) {
		jdbcTemplate.update("insert into product(name,price,quantity) values(?, ?, ?)", product.getName(), product.getPrice(), product.getQuantity());
	}

	@Override
	public List<Product> getAvailableProducts() {
		return jdbcTemplate.query("select * from product", BeanPropertyRowMapper.newInstance(Product.class));
	}

}
