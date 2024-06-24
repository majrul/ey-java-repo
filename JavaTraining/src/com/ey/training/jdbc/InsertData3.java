package com.ey.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//TODO: Create table first in the DB:
//create table product(id int primary key auto_increment, name varchar(20), price double, quantity int);
public class InsertData3 {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");

			String sql = "insert into product(name,price,quantity) values(?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql);

			Scanner s = new Scanner(System.in);
			System.out.println("Enter product name");
			String name = s.nextLine();
			System.out.println("Enter price of the product");
			double price = Double.parseDouble(s.nextLine());
			System.out.println("Enter quantity of the product");
			int quantity = Integer.parseInt(s.nextLine());
			
			//substituting ? with the actual value
			st.setString(1, name);
			st.setDouble(2, price);
			st.setInt(3, quantity);
			
			st.executeUpdate();
			
			//TODO: Fetch the generated id of the record inserted and display it
			
			System.out.println("Record inserted..");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}

	}
}
