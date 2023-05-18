package com.example.library.businessLogicLayer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.businessLogicLayer.dtos.AuthorDto;
import com.example.library.businessLogicLayer.dtos.BookDto;
import com.example.library.domainLayer.repositories.BookRepository;


@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;
	
	public List<BookDto> getBooks(){
		return null;
		
	}
	
	public AuthorDto getBookById() {
		return null;
	}
	
	public void createBook() {
		
	}
	
	public void updateBook() {
		
	}
	
	public void deleteBook() {
		
	}

}
