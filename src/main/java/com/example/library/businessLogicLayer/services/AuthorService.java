package com.example.library.businessLogicLayer.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.businessLogicLayer.dtos.AuthorDto;
import com.example.library.businessLogicLayer.dtos.converters.AuthorDtoConverter;
import com.example.library.domainLayer.repositories.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository repo;
	
	public List<AuthorDto> getAuthors(){
		return repo.findAll()
				.stream()
				.map(a->AuthorDtoConverter.toDto(a))
				.collect(Collectors.toList());
		
	}
	
	public AuthorDto getAuthorById(int id) {
		AuthorDto author = AuthorDtoConverter.toDto(repo.findById(id).get()) ;
		return author;
	}
	
	public void createAuthor() {
		
	}
	
	public void updateAuthor() {
		
	}
	
	public void deleteAutor() {
		
	}

}
