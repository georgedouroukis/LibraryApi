package com.example.library.apiLayer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.businessLogicLayer.dtos.AuthorDto;
import com.example.library.businessLogicLayer.services.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/get")
	public List<AuthorDto> getAuthors(){
		return authorService.getAuthors();
		
	}
	
	@GetMapping("/get/{id}")
	public AuthorDto getAuthorById(@PathVariable("id") Integer id) {
		return authorService.getAuthorById(id);
		
	}
}
