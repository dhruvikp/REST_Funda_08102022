package com.simplilearn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.model.Greet;

@RestController
public class GreetController {

	// @GetMapping("/greet")
	@RequestMapping(value = "/greet", method = RequestMethod.GET)
	public Greet greet() {
		Greet greet = new Greet();
		greet.setMessage("Hello, Simplilearn!");
		greet.setName("Dhruvik");

		return greet;
	}
}
// @RestController = @Controller + @ResponseBody