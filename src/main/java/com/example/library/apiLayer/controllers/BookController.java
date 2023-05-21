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
import com.example.library.businessLogicLayer.dtos.BookDto;
import com.example.library.businessLogicLayer.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping({"/",""})
	public ResponseEntity<ResponseContainer<?>> getBooks(){
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.getBooks();}},HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseContainer<?>> getBookById(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.getBookById(id);}},HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<ResponseContainer<?>> createBook(@RequestBody BookDto dto) {

		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.createBook(dto);}},HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/save")
	public ResponseEntity<ResponseContainer<?>> updateBook(@RequestBody BookDto dto) {

		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.updateBook(dto);}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/{bookId}/add/author/{authorId}")
	public ResponseEntity<ResponseContainer<?>> bookAddAuthor(@PathVariable("bookId") Integer bookId,@PathVariable("authorId") Integer authorId) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.addAuthor(bookId, authorId);}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{bookId}/remove/author/{authorId}")
	public ResponseEntity<ResponseContainer<?>> bookRemoveAuthor(@PathVariable("bookId") Integer bookId,@PathVariable("authorId") Integer authorId) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.removeAuthor(bookId, authorId);}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}/authors")
	public ResponseEntity<ResponseContainer<?>> getBookAuthors(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.getAuthors(id);}},HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/{bookId}/add/genre/{genreId}")
	public ResponseEntity<ResponseContainer<?>> bookAddGenre(@PathVariable("bookId") Integer bookId,@PathVariable("genreId") Integer genreId) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.addGenre(bookId, genreId);}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{bookId}/remove/genre/{genreId}")
	public ResponseEntity<ResponseContainer<?>> bookRemoveGenre(@PathVariable("bookId") Integer bookId,@PathVariable("genreId") Integer genreId) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.removeGenre(bookId, genreId);}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}/genres")
	public ResponseEntity<ResponseContainer<?>> getBookGenres(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.getGenres(id);}},HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{bookId}/add/publisher/{publisherId}")
	public ResponseEntity<ResponseContainer<?>> bookAddPublisher(@PathVariable("bookId") Integer bookId,@PathVariable("publisherId") Integer publisherId) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.addOrReplacePublisher(bookId, publisherId);}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{bookId}/remove/publisher")
	public ResponseEntity<ResponseContainer<?>> bookRemovePublisher(@PathVariable("bookId") Integer bookId) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.removePublisher(bookId);}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}/publisher")
	public ResponseEntity<ResponseContainer<?>> getBookPublisher(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.getPublisher(id);}},HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseContainer<?>> deleteBook(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.deleteBook(id);}},HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
