package com.gary.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gary.bookclub.models.Book;
import com.gary.bookclub.repositories.BookRepository;


@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	// Find All
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	
	
	// Find One
	public Book oneBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	// Create Book
		public Book createBook(Book newBook) {
			return bookRepo.save(newBook);
		}
		
	
	// Update Book
		public Book updateBook(Book updatedBook) {
			return bookRepo.save(updatedBook);
		}
		
		
		// Delete Book
		public void deleteBookById(Long id) {
			bookRepo.deleteById(id);
		}
		
	
	
	
}
