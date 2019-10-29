package com.example.demo.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/*
 * global ExceptionHandler class
 */
@Controller
@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = NullPointerException.class)
	public String nullPointerException(Model model) {
		model.addAttribute("errMsg", "some problem is occured . plz try some time ...!!");
		return "error";

	}

	@ExceptionHandler(value = NoBookFoundException.class)
	public String handleNoBookFoundException(Model model) {
		return "customError";
	}
	
}
