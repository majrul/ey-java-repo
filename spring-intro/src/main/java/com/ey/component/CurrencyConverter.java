package com.ey.component;

import org.springframework.stereotype.Component;

@Component("currConv") //alternative to <bean id="currConv" class="com.ey.training.component.CurrencyConverter" />
public class CurrencyConverter {

	public double convert(String from, String to, double amount) {
		if(from.equals("USD") && to.equals("INR"))
			return amount * 83.58;
		else if(from.equals("GBP") && to.equals("INR"))
			return amount * 105.65;
		return 0; //rather throw exception
	}
}
