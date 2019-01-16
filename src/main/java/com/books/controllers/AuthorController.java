package com.books.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.models.Author;
import com.books.repositories.AuthorRepository;

import javassist.NotFoundException;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	private AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}
	
	@GetMapping
	public Iterable<Author> list(){
		return authorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Author> findById(@PathVariable Long id) throws NotFoundException {
		Optional<Author> authorOpt = authorRepository.findById(id);
		
		ResponseEntity<Author> response;
		
		if (authorOpt.isPresent()) {
			response = new ResponseEntity<Author>(authorOpt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
}
