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
import com.example.library.businessLogicLayer.dtos.PublisherDto;
import com.example.library.businessLogicLayer.services.PublisherService;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

	
	@Autowired
	private PublisherService publisherService;
	
	@GetMapping("/get")
	public ResponseEntity<ResponseContainer<?>> getPublishers(){
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=publisherService.getPublishers();}},HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseContainer<?>> getPublisherById(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=publisherService.getPublisherById(id);}},HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<ResponseContainer<?>> createPublisher(@RequestBody PublisherDto dto) {

		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=publisherService.createPublisher(dto);}},HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/save")
	public ResponseEntity<ResponseContainer<?>> updatePublisher(@RequestBody PublisherDto dto) {

		try {
			return new ResponseEntity<>(new ResponseContainer<>() {{data=publisherService.createPublisher(dto);}},HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new ResponseContainer<>() {{error=e.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
