package com.ey.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("calc")
//@Scope("singleton")
public class Calculator {

	public int add(int x, int y) {
		return x + y;
	}

	public int sub(int x, int y) {
		return x - y;
	}
}
