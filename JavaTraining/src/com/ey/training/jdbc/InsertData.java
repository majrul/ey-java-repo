package com.ey.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//TODO: Create table first in the DB:
//create table product(id int primary key auto_increment, name varchar(20), price double, quantity int);
public class InsertData {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			
			Statement st = conn.createStatement();
			st.executeUpdate("insert into product(name,price,quantity) values('iPhone 13', 49000, 25)"); //DML
			//st.executeUpdate("update product set quantity = 50");
			
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
