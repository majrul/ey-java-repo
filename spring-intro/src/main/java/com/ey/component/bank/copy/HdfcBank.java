package com.ey.component.bank.copy;

import org.springframework.stereotype.Component;

@Component
public class HdfcBank implements Bank {

	@Override
	public boolean doesAccountExists(int acno) {
		if(acno == 98765)
			return true;
		return false;
	}

	@Override
	public void withdraw(int atmId, int acno, double amount) {
		System.out.println("Customer of HdfcBank wants to withdraw money..");
	}
}
