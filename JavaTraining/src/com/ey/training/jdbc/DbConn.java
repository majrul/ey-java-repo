package com.ey.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

//TODO:
//In Eclipse->Right click on the project->
//				Build Path -> Configure Build Path
//								-> Libraries
//									-> Classpath
//										-> Add External JARs
//											-> Then browse and select the mysql driver jar and Finish
public class DbConn {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			//Driver driver = new Driver();
			//we want to just load the driver, but not instantiate it
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("org.apache.derby.jdbc.ClientDriver");
			//Check Reflection API for more understanding on Class.forName(..);
			//Class c = Driver.class;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			//conn = DriverManager.getConnection("jdbc:derby://localhost:1527/training", "root", "root");
			System.out.println("got connected..");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
