package com.example.demo.exceptionhand;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Controller
@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = NullPointerException.class)
	public String nullPointerException(Model model) {
		model.addAttribute("errMsg", "some problem is occured . plz try some time ...!!");
		return "error";

	}

	@ExceptionHandler(value = NumberFormatException.class)

	public String handleNoBookFoundException(Model model) {
		model.addAttribute("errMsg", "some problem is occured . plz try some time ...!!");
		return "error";
	}

}
