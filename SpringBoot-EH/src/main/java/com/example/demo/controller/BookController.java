package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/findPriceByID")
	public String getFindByid(@RequestParam("bookId") String bookId,Model model) {
		
		Double bookPrice=bookService.findById(bookId);
		model.addAttribute("price", "Book Price : "+bookPrice);
		return "display";
	}

}
