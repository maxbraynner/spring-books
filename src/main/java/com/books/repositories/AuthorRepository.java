package com.books.repositories;

import org.springframework.data.repository.CrudRepository;

import com.books.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
