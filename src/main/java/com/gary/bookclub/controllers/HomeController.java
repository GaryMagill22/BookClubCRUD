package com.gary.bookclub.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gary.bookclub.models.Book;

@Controller
public class HomeController {

	

	
//	
//	@GetMapping("/")
//	public String renderLoginRegForm() {
//		return "loginregister.jsp";
//	}
	
	//Create Book
	//Render Form
	@GetMapping("/books/new")
	public String renderBookForm(@ModelAttribute("newBook") Book newBook) {
		return "createBook.jsp";
	}
	
	
}
