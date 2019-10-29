package com.example.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateController {

	@RequestMapping(value = "/date")
	public String diaplayDate(Model model) {
		model.addAttribute("dateMsg", "Todays date : " + new Date());
		String date = null;
		date.length();
		return "dateDisplay";
	}

}
