package com.ey.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("prodInv1")
public class ProductInventoryImpl1 implements ProductInventory {

	@Override
	public void add(Product product) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");

			String sql = "insert into product(name,price,quantity) values(?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, product.getName());
			st.setDouble(2, product.getPrice());
			st.setInt(3, product.getQuantity());
			
			st.executeUpdate();
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

	@Override
	public List<Product> getAvailableProducts() {
		return null;
	}

}
