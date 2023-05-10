package com.example.library;


import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.library.domainLayer.models.Book;
import com.example.library.domainLayer.repositories.AuthorRepository;
import com.example.library.domainLayer.repositories.BookRepository;
import com.example.library.domainLayer.repositories.GenreRepository;
import com.example.library.domainLayer.repositories.PublisherRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
class DomainLayerTests {

	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private PublisherRepository publisherRepo;
	
	@Autowired
	private GenreRepository genreRepo;
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@Test
	@Transactional
	void contextLoads() {
		
		
		List<Book> books = new ArrayList<>();
		bookRepo.findAll().forEach(b->books.add(b));
//		bookRepo.findAll().forEach(b->{books.add(b);
//									books.forEach(book->book.getAuthors().forEach(a->System.out.println(a.getLastName()+a.getFirstName())));});
		
		
		books.forEach(b->System.out.println(b.getPublisher().getEmail()));
		
		Assertions.assertThat(true).isEqualTo(true);
		
		
		
		
	}

}
