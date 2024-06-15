package com.ey.training.exceptions;

class Account {
	int acno;
	String name;
	double balance;
	
	Account(int acno, String name, double balance) {
		this.acno = acno;
		this.name = name;
		this.balance = balance;
	}
	
	//double withdraw(double amount) throws Exception {
	//double withdraw(double amount) throws RuntimeException {
	double withdraw(double amount) throws AccountException {
		if(amount > balance) {
			//Exception e = new Exception("Insufficient Balance!");
			//RuntimeException e = new RuntimeException("Insufficient Balance!");
			AccountException e = new AccountException("Insufficient Balance!");
			throw e;
		}
		else {
			balance -= amount;
			return balance;
		}
	}
}

class AccountException extends Exception {
	
	AccountException(String msg) {
		super(msg);
	}
}
public class Ex2 {

	public static void main(String[] args) {
		Account acc = new Account(1111, "Majrul", 5000);
		try {
			double balance = acc.withdraw(6000);
			System.out.println("Balance left : " + balance);
		}
		catch(AccountException e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
		}
		catch(OutOfMemoryError e) { //this is a bad thing we have done
			
		}
		finally {
			//some cleanup code here
		}
	}
}
