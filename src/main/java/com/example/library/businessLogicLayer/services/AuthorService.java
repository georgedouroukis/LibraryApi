package com.example.library.businessLogicLayer.services;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.businessLogicLayer.dtos.AuthorDto;
import com.example.library.businessLogicLayer.dtos.BookDto;
import com.example.library.businessLogicLayer.dtos.converters.AuthorDtoConverter;
import com.example.library.businessLogicLayer.dtos.converters.BookDtoConverter;
import com.example.library.domainLayer.models.Author;
import com.example.library.domainLayer.models.Book;
import com.example.library.domainLayer.repositories.AuthorRepository;


@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@Autowired
	private BookDtoConverter bookDtoConverter;
	
	@Autowired
	private AuthorDtoConverter authorDtoConverter;
	
	public Collection<AuthorDto> getAuthors(){
		return authorRepo.findAll()
				.stream()
				.map(a->authorDtoConverter.toDto(a))
				.collect(Collectors.toSet());
	}
	
	public AuthorDto getAuthorById(int id) {
		AuthorDto author = authorDtoConverter.toDto(
				authorRepo.findById(id).get()) ;
		return author;
	}
	
	public int createAuthor(AuthorDto dto) {
		Author newAuthor = authorDtoConverter.toEntity(dto);
		authorRepo.save(newAuthor);
		return newAuthor.getId();
		
	}
	
	public int updateAuthor(AuthorDto dto) {
		Author author = authorRepo.findById(dto.getId()).get();
		Author temp = authorDtoConverter.toEntity(dto);
		author.setFirstName(dto.getFirstName());
		author.setLastName(dto.getLastName());
		author.setMiddleName(dto.getMiddleName());
		author.setDescription(dto.getDescription());
		author.setBooks(temp.getBooks());
		authorRepo.save(author);
		return author.getId();
		
	}
	
	public Collection<BookDto> getBooks(int id){
		Author author = authorRepo.findById(id).get();
		Collection<Book> books = author.getBooks();
		Collection<BookDto> booksdtos = books.stream().map(b->bookDtoConverter.toDto(b)).collect(Collectors.toSet());
		return booksdtos;
	}

	public String deleteAuthor(int id) {
		Author author = authorRepo.findById(id).get();
		authorRepo.delete(author);
		return "success";
		// errors handled in controllers
	}

}
