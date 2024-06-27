package com.ey.component.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sbiatm1")
public class SbiAtm implements Atm {

	@Autowired
	private Bank bank;
	
	@Override
	public void withdraw(int acno, double amount) {
		System.out.println("Customer at SbiAtm to withdraw money..");
		bank.withdraw(1111, acno, amount);
	}
}
