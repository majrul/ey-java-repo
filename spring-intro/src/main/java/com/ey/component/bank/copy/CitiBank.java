package com.ey.component.bank.copy;

import org.springframework.stereotype.Component;

@Component
public class CitiBank implements Bank {

	@Override
	public boolean doesAccountExists(int acno) {
		if(acno == 12345)
			return true;
		return false;
	}
	
	@Override
	public void withdraw(int atmId, int acno, double amount) {
		System.out.println("Customer of Citibank wants to withdraw money..");
	}
}
