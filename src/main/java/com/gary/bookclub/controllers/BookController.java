package com.gary.bookclub.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.gary.bookclub.models.Book;
import com.gary.bookclub.services.BookService;
import com.gary.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class BookController {

	
	
//	
	@Autowired
	private UserService userService;
//	
	@Autowired
	private BookService bookService;
	
	
	

		
		//Create Book
		// process form
		@PostMapping("/books/create")
		public String processBookForm(
				@Valid @ModelAttribute("newBook") Book newBook, BindingResult result) {
			if(result.hasErrors()) {
				return "createBook.jsp";
			} else {
				bookService.createBook(newBook);
				return "redirect:/books";
			}
		}
		
		
		
		
		@GetMapping("/books")
		public String dashboard(Model model, HttpSession session) {
			// Getting User Id
			if(session.getAttribute("userId") == null) {
				return "redirect:/users/";
			} model.addAttribute("loggedInUser", userService.getUser((Long)session.getAttribute("userId")));
			model.addAttribute("bookList", bookService.allBooks());
			return "dashboard.jsp";
		}
		
		
		
		// 	Rendering Details for one Book
		//  Book Details
		@GetMapping("/books/{id}")
		public String bookDetails(@PathVariable("id")Long id, Model model) {
			model.addAttribute("book", bookService.oneBook(id));
			return "bookDetails.jsp";
		}
		
		
		// EDIT =================
		
		// Process the Edit form
		@PutMapping("/books/{id}/edit")
		public String processEditBook(@Valid @ModelAttribute("book") Book book,
				BindingResult result) {
			if(result.hasErrors()) {
				return "editBook.jsp";
			} else {
				Book updatedBook = bookService.updateBook(book);
				return "redirect:/books";
//				return "redirect:/books/"+ updatedBook.getId();
			}
		}
		
		
		
		// Edit
		// Render the form
		@GetMapping("/books/{id}/edit")
		public String renderEditBook(@PathVariable("id")Long id, Model model) {
			Book book = bookService.oneBook(id);
			model.addAttribute("book", bookService.oneBook(id));
			return "editBook.jsp";
		}
		
		
		
		
		// Delete Book 
		@DeleteMapping("/books/{id}")
		public String processDelete(@PathVariable("id") Long id) {
			bookService.deleteBookById(id);
			return "redirect:/books";
		}
		
		
}
