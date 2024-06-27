package com.ey.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ey.component.Calculator;
import com.ey.component.CurrencyConverter;
import com.ey.component.Greeting;
import com.ey.component.HelloWorld;
import com.ey.component.LoginService;
import com.ey.component.TextEditor;
import com.ey.component.bank.copy.Atm;

public class App {

	public static void main(String[] args) {
		//Loading the Configuration of Spring
		ApplicationContext ctx = new ClassPathXmlApplicationContext("my-spring-config.xml");
		
		//Access a bean
		HelloWorld h = (HelloWorld) ctx.getBean("hello"); //bean id
		System.out.println(h.sayHello("Majrul"));
		
		Greeting g = (Greeting) ctx.getBean("greet");
		System.out.println(g.greet());
		
		CurrencyConverter cc = (CurrencyConverter) ctx.getBean("currConv");
		System.out.println(cc.convert("USD", "INR", 100));
		
		Calculator c = (Calculator) ctx.getBean("calc");
		System.out.println(c.add(10, 20));
		
		LoginService loginServ = (LoginService) ctx.getBean("loginService");
		System.out.println(loginServ.isValidUser("majrul", "123"));
		
		TextEditor te = (TextEditor) ctx.getBean("txtEdtr");
		te.load("abc.txt");
		
		Atm atm = (Atm) ctx.getBean("sbiatm2");
		atm.withdraw(98765, 5000);
		
		//Why are we not creating object of HelloWorld class:
		//HelloWorld h = new HelloWorld(); ??????
		
	}
}
