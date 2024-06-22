package com.ey.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FetchData {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");

			String sql = "select * from product where price >= ?";
			PreparedStatement st = conn.prepareStatement(sql); 

			Scanner s = new Scanner(System.in);
			System.out.println("Enter price value of the products to search for");
			double basePrice = Double.parseDouble(s.nextLine());
			
			st.setDouble(1, basePrice); //substituting ? with actual value in the query above
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) { //next row
				int id = rs.getInt("id"); //column
				String name = rs.getString("name"); //column
				double price = rs.getDouble("price"); //column
				int quantity = rs.getInt("quantity"); //column

				System.out.println(id + " , " + name + " , " + price + " , " + quantity);
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}

	}
}
