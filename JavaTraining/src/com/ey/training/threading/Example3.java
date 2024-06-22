package com.ey.training.threading;

class Account {
	int acno;
	String name;
	double balance;
	
	Account(int acno, String name, double balance) {
		this.acno = acno;
		this.name = name;
		this.balance = balance;
	}
	
	synchronized void withdraw(double amount) {
		try {
			Thread.sleep(100);
			if(amount < balance) {
				Thread.sleep(100);
				balance -= amount;
				Thread.sleep(100);
				System.out.println("Balance left " + balance);
			}
			else {
				System.out.println("Insufficient Balance!");
			}
		}
		catch(InterruptedException e) { }
	}
}

class Transaction implements Runnable {
	
	Account account;
	
	Transaction(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		account.withdraw(4000);
	}
}

public class Example3 {

	public static void main(String[] args) {
		Account acc = new Account(111, "Majrul", 5000);
		Transaction tx1 = new Transaction(acc);
		Transaction tx2 = new Transaction(acc);
		Thread th1 = new Thread(tx1);
		Thread th2 = new Thread(tx2);
		th1.start();
		th2.start();
	}
}
