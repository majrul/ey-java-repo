package com.ey.component.bank;

import org.springframework.stereotype.Component;

@Component("citibank1")
public class CitiBank implements Bank {

	@Override
	public void withdraw(int atmId, int acno, double amount) {
		System.out.println("Customer of Citibank wants to withdraw money..");
	}
}
