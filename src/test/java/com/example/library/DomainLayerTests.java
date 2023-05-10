package com.example.library;


import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.library.domainLayer.models.Book;
import com.example.library.domainLayer.repositories.AuthorRepository;
import com.example.library.domainLayer.repositories.BookRepository;
import com.example.library.domainLayer.repositories.GenreRepository;
import com.example.library.domainLayer.repositories.PublisherRepository;

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
	void contextLoads() {
		
		
		List<Book> books = new ArrayList<>();
		bookRepo.findAll().forEach(b->books.add(b));
		books.forEach(b->System.out.println(b.getTitle()));
		System.out.println(books);
		
		Assertions.assertThat(true).isEqualTo(true);
		
		
		
		
	}

}
