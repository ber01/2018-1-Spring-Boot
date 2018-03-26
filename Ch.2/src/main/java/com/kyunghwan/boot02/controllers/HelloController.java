package com.kyunghwan.boot02.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello") 
	String hello() { 
		return "Hello World"; 
	} 
}
