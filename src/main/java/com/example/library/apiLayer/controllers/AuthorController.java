package com.example.library.apiLayer.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.apiLayer.models.ResponseContainer;
import com.example.library.businessLogicLayer.dtos.AuthorDto;
import com.example.library.businessLogicLayer.services.AuthorService;
import com.example.library.businessLogicLayer.services.BookService;


@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping({"/",""})
	public ResponseEntity<ResponseContainer<?>> getAuthors(){
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=authorService.getAuthors();}},HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseContainer<?>> getAuthorById(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=authorService.getAuthorById(id);}},HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<ResponseContainer<?>> createAuthor(@RequestBody AuthorDto dto) {

		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=authorService.createAuthor(dto);}},HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/save")
	public ResponseEntity<ResponseContainer<?>> updateAuthor(@RequestBody AuthorDto dto) {

		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=authorService.updateAuthor(dto);}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{authorId}/add/{bookId}")
	public ResponseEntity<ResponseContainer<?>> authorAddBook(@PathVariable("authorId") Integer authorId,@PathVariable("bookId") Integer bookId) {
		try {
			//mapped by book service
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.addAuthor(bookId, authorId);}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{authorId}/remove/{bookId}")
	public ResponseEntity<ResponseContainer<?>> authorRemoveBook(@PathVariable("authorId") Integer authorId,@PathVariable("bookId") Integer bookId) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.removeAuthor(bookId, authorId);;}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}/books")
	public ResponseEntity<ResponseContainer<?>> getAuthorBooks(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=authorService.getBooks(id);}},HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseContainer<?>> deleteAuthor(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=authorService.deleteAuthor(id);}},HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
