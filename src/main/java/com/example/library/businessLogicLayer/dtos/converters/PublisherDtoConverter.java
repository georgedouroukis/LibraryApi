package com.example.library.businessLogicLayer.dtos.converters;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.businessLogicLayer.dtos.PublisherDto;
import com.example.library.domainLayer.models.Book;
import com.example.library.domainLayer.models.Publisher;
import com.example.library.domainLayer.repositories.BookRepository;

@Service
public class PublisherDtoConverter {
	
	@Autowired
	private BookRepository bookRepo;
	
	public PublisherDto toDto(Publisher p) {
		
		return new PublisherDto(
				p.getId(),
				p.getName(),
				p.getPhone(),
				p.getEmail(),
				p.getBooks().stream().map(b->b.getId()).collect(Collectors.toSet()));
		
		
	}
	
	public Publisher toEntity(PublisherDto dto) {

		Publisher publisher = new Publisher();
		publisher.setName(dto.getName());
		publisher.setPhone(dto.getPhone());
		publisher.setEmail(dto.getEmail());
		Set<Book> books = dto.getBooks().stream().map(bookId->bookRepo.findById(bookId).get()).collect(Collectors.toSet());
		publisher.setBooks(books);
		return publisher;
	}

}
