package com.books.repositories;

import org.springframework.data.repository.CrudRepository;

import com.books.models.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
