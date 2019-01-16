package com.books.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.models.Book;
import com.books.repositories.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {
	
	private BookRepository bookRepository;
	
	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@GetMapping
	public Iterable<Book> lisBoobks() {
		return bookRepository.findAll();
	}
	
}
