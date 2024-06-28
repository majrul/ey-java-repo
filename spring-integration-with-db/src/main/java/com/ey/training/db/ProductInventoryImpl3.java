package com.ey.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("prodInv3")
public class ProductInventoryImpl3 implements ProductInventory {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public void add(Product product) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		jt.update("insert into product(name,price,quantity) values(?, ?, ?)", product.getName(), product.getPrice(), product.getQuantity());
	}

	@Override
	public List<Product> getAvailableProducts() {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		List<Product> list = jt.query("select * from product", 
							BeanPropertyRowMapper.newInstance(Product.class));
		return list;
	}

}
