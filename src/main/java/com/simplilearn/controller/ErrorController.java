package com.simplilearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

	@GetMapping("/calculate")
	public Integer calculate() {
		int a = 6;
		int b = 0;
		int result = a / b;
		return result;
	}
}
