package com.ey.component;

import org.springframework.stereotype.Component;

@Component("calc")
public class Calculator {

	public int add(int x, int y) {
		return x + y;
	}

	public int sub(int x, int y) {
		return x - y;
	}
}
