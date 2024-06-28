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
import org.springframework.stereotype.Component;

@Component("prodInv2")
public class ProductInventoryImpl2 implements ProductInventory {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public void add(Product product) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into product(name,price,quantity) values(?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, product.getName());
			st.setDouble(2, product.getPrice());
			st.setInt(3, product.getQuantity());
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

	@Override
	public List<Product> getAvailableProducts() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();

			String sql = "select * from product";
			PreparedStatement st = conn.prepareStatement(sql); 
			ResultSet rs = st.executeQuery();
			
			List<Product> list = new ArrayList<Product>();
			while(rs.next()) { //next row
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setQuantity(rs.getInt("quantity"));
				list.add(product);
			}
			return list;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null; //bad, rather we should have thrown exception
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}

	}

}
