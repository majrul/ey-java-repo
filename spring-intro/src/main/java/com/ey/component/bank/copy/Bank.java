package com.ey.component.bank.copy;

public interface Bank {

	public boolean doesAccountExists(int acno);
	public void withdraw(int atmId, int acno, double amount);

}
