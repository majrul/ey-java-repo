package com.ey.training.threading;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.Semaphore;

class ConnectionPool {

	Semaphore semaphore = new Semaphore(3);
	
	Connection getConnection() {
		try { 
			semaphore.acquire();
			Connection conn = DriverManager.getConnection(null);
			return conn;
		}
		catch (InterruptedException | SQLException e) {
			return null;
		}
	}
	
	void releaseConnection(Connection conn) {
		semaphore.release();
		//try { conn.close(); } catch(SQLException e) { }
	}
}

class UserService implements Runnable {

	ConnectionPool connectionPool;

	UserService(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() +" trying to acquire a connection..");
		Connection conn = connectionPool.getConnection();
		System.out.println(Thread.currentThread().getName() +" acquired a connection..");
		//then we will go and fetch some data from the db
		try { Thread.sleep(1000); } catch(InterruptedException e) { }
		connectionPool.releaseConnection(conn);
		System.out.println(Thread.currentThread().getName() +" released the connection..");
	}
}

public class Example4 {

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPool();
		UserService us = new UserService(cp);
		
		for(int i=0; i<10; i++) {
			new Thread(us).start();
		}
	}
}
