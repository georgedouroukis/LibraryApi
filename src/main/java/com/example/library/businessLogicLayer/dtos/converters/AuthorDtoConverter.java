package com.example.library.businessLogicLayer.dtos.converters;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.businessLogicLayer.dtos.AuthorDto;
import com.example.library.domainLayer.models.Author;
import com.example.library.domainLayer.models.Book;
import com.example.library.domainLayer.repositories.BookRepository;

@Service
public class AuthorDtoConverter {
	
	@Autowired
	private BookRepository bookRepo;

	public AuthorDto toDto(Author a) {
		
		return new AuthorDto(
				a.getId(),
				a.getFirstName(),
				a.getLastName(),
				a.getMiddleName(),
				a.getDescription(),
				a.getBooks().stream().map(b->b.getId()).collect(Collectors.toSet()));
		
		
	}
	
	public Author toEntity(AuthorDto dto) {

		Author author = new Author();
		author.setFirstName(dto.getFirstName());
		author.setLastName(dto.getLastName());
		author.setMiddleName(dto.getMiddleName());
		author.setDescription(dto.getDescription());
		Set<Book> books = dto.getBooks().stream().map(bookId->bookRepo.findById(bookId).get()).collect(Collectors.toSet());
		author.setBooks(books);
		
		return author;
	}
}
