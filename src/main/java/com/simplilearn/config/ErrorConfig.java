package com.simplilearn.config;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@ControllerAdvice
public class ErrorConfig {

	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public String exception() {
		return "Internal Server Error";
	}
	
	@ExceptionHandler(value=ArithmeticException.class)
	@ResponseBody
	public String arithmaticException() {
		return "Arith: Internal Server Error";
	}
}
