package com.ey.training.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			long ms1 = System.currentTimeMillis();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			long ms2 = System.currentTimeMillis();
			System.out.println("approx time taken to connect to db " + (ms2 - ms1) + " ms");
			
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
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null; //bad, rather we should have thrown exception
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}

	}

}
