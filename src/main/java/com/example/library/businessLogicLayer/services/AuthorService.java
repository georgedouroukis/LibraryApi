package com.example.library.businessLogicLayer.services;

import java.util.List;
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
import com.example.library.domainLayer.repositories.BookRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<AuthorDto> getAuthors(){
		return authorRepo.findAll()
				.stream()
				.map(a->AuthorDtoConverter.toDto(a))
				.collect(Collectors.toList());
		
	}
	
	public AuthorDto getAuthorById(int id) {
		AuthorDto author = AuthorDtoConverter.toDto(
				authorRepo.findById(id).get()) ;
		return author;
	}
	
	public int createAuthor(AuthorDto dto) {
		Author newAuthor = AuthorDtoConverter.toEntity(dto);
		authorRepo.save(newAuthor);
		return newAuthor.getId();
		
	}
	
	public int updateAuthor(AuthorDto dto) {
		Author author = authorRepo.findById(dto.getId()).get();
		author.setFirstName(dto.getFirstName());
		author.setLastName(dto.getLastName());
		author.setMiddleName(dto.getMiddleName());
		authorRepo.save(author);
		return author.getId();
		
	}
	
	//mapped also by BookService
	public void addBook(int authorId, int bookId) {
		Book book = bookRepo.findById(bookId).get();
		Author author = authorRepo.findById(authorId).get();
		author.getBooks().add(book);
		authorRepo.save(author);
	}
	
	//mapped also by BookService
	public void removeBook(int authorId, int bookId) {
		Book book = bookRepo.findById(bookId).get();
		Author author = authorRepo.findById(authorId).get();
		author.getBooks().removeIf(b->b.equals(book));
		authorRepo.save(author);
	}
	
	public List<BookDto> getBooks(int id){
		Author author = authorRepo.findById(id).get();
		List<Book> books = author.getBooks();
		List<BookDto> booksdtos = books.stream().map(b->BookDtoConverter.toDto(b)).collect(Collectors.toList());
		return booksdtos;
	}

	public void deleteAuthor(int id) {
		Author author = authorRepo.findById(id).get();
		authorRepo.delete(author);
	}

}
