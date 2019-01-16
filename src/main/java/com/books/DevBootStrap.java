package com.books;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.books.models.Author;
import com.books.models.Book;
import com.books.models.Publisher;
import com.books.repositories.AuthorRepository;
import com.books.repositories.BookRepository;
import com.books.repositories.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	private void initData() {
		Author author = new Author("Max", "Braynner");
		authorRepository.save(author);
		
		Publisher publisher = new Publisher("Amazon");
		publisherRepository.save(publisher);
		
		Book book = new Book("Estudando Spring", "123456", publisher);
		book.getAuthors().add(author);
		bookRepository.save(book);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}
	
}
