package com.ey.component.bank.copy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sbiatm2")
public class SbiAtm implements Atm {

	//@Autowired
	//private Bank bank;
	
	@Autowired
	private List<Bank> banks;
	
	@Override
	public void withdraw(int acno, double amount) {
		System.out.println("Customer at SbiAtm to withdraw money..");
		Bank currentBank = null;
		for(Bank bank : banks) {
			if(bank.doesAccountExists(acno)) {
				currentBank = bank;
				break;
			}
		}
		currentBank.withdraw(1111, acno, amount);
	}
}
