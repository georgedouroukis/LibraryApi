package com.example.library.apiLayer.controllers;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.apiLayer.models.ResponseContainer;
import com.example.library.businessLogicLayer.dtos.GenreDto;
import com.example.library.businessLogicLayer.services.GenreService;

@RestController
@RequestMapping("/genres")
public class GenreController {

	@Autowired
	private GenreService genreService;
	
	@GetMapping("/get")
	public ResponseEntity<ResponseContainer<?>> getGenres(){
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=genreService.getGenres();}},HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{id}")
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
}
