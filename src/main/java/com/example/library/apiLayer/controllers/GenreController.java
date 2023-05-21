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
import com.example.library.businessLogicLayer.dtos.GenreDto;
import com.example.library.businessLogicLayer.services.BookService;
import com.example.library.businessLogicLayer.services.GenreService;

@RestController
@RequestMapping("/genres")
public class GenreController {

	@Autowired
	private GenreService genreService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping({"/",""})
	public ResponseEntity<ResponseContainer<?>> getGenres(){
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=genreService.getGenres();}},HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseContainer<?>> getGenreById(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=genreService.getGenreById(id);}},HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<ResponseContainer<?>> createGenre(@RequestBody GenreDto dto) {

		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=genreService.createGenre(dto);}},HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/save")
	public ResponseEntity<ResponseContainer<?>> updateGenre(@RequestBody GenreDto dto) {

		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=genreService.updateGenre(dto);}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{genreId}/add/book/{bookId}")
	public ResponseEntity<ResponseContainer<?>> genreAddBook(@PathVariable("genreId") Integer genreId,@PathVariable("bookId") Integer bookId) {
		try {
			//mapped by book service
			return new ResponseEntity<>(new ResponseContainer<>() {{data=bookService.addGenre(bookId, genreId);}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{genreId}/remove/book/{bookId}")
	public ResponseEntity<ResponseContainer<?>> genreRemoveBook(@PathVariable("genreId") Integer genreId,@PathVariable("bookId") Integer bookId) {
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
	
	@GetMapping("/{id}/books")
	public ResponseEntity<ResponseContainer<?>> getGenreBooks(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=genreService.getBooks(id);}},HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{genreId}/add/sub/{subId}")
	public ResponseEntity<ResponseContainer<?>> genreAddSub(@PathVariable("genreId") Integer genreId,@PathVariable("subId") Integer subId) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=genreService.addSubGenre(genreId, subId);}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{genreId}/remove/sub/{subId}")
	public ResponseEntity<ResponseContainer<?>> genreRemoveSub(@PathVariable("genreId") Integer genreId,@PathVariable("subId") Integer subId) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=genreService.removeSubGenre(genreId, subId);}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}/subs")
	public ResponseEntity<ResponseContainer<?>> getGenreSubs(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=genreService.getSubGenres(id);}},HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{genreId}/add/parent/{parentId}")
	public ResponseEntity<ResponseContainer<?>> genreAddParent(@PathVariable("genreId") Integer genreId,@PathVariable("parentId") Integer parentId) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=genreService.addOrReplaceParentGenre(genreId, parentId);}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{genreId}/remove/parent")
	public ResponseEntity<ResponseContainer<?>> genreRemoveParent(@PathVariable("genreId") Integer genreId) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=genreService.removeParentGenre(genreId);}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}/parent")
	public ResponseEntity<ResponseContainer<?>> getGenreParent(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=genreService.getParentGenre(id);}},HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseContainer<?>> deleteGenre(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=genreService.deleteGenre(id);}},HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
