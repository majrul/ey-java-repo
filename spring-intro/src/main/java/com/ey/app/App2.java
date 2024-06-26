package com.ey.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ey.component.Calculator;
import com.ey.component.CurrencyConverter;
import com.ey.component.Greeting;
import com.ey.component.HelloWorld;
import com.ey.component.LoginService;
import com.ey.config.MySpringConfig;

public class App2 {

	public static void main(String[] args) {
		//Loading the Configuration of Spring
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MySpringConfig.class);
				
		CurrencyConverter cc = (CurrencyConverter) ctx.getBean("currConv");
		System.out.println(cc.convert("USD", "INR", 100));
		
		Calculator c = (Calculator) ctx.getBean("calc");
		System.out.println(c.add(10, 20));
		
		LoginService loginServ = (LoginService) ctx.getBean("loginService");
		System.out.println(loginServ.isValidUser("majrul", "123"));
		
		//Why are we not creating object of HelloWorld class:
		//HelloWorld h = new HelloWorld(); ??????
		
	}
}
