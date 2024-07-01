package com.ey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	//@RequestMapping(path = "/hello", method = RequestMethod.POST)
	@GetMapping("/hello")
	public String hello() {
		return "Hello from Spring Boot and REST API Development";
	}
}
