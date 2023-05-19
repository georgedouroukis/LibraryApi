package com.example.library.businessLogicLayer.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.businessLogicLayer.dtos.BookDto;
import com.example.library.businessLogicLayer.dtos.PublisherDto;
import com.example.library.businessLogicLayer.dtos.converters.BookDtoConverter;
import com.example.library.businessLogicLayer.dtos.converters.PublisherDtoConverter;
import com.example.library.domainLayer.models.Book;
import com.example.library.domainLayer.models.Publisher;
import com.example.library.domainLayer.repositories.BookRepository;
import com.example.library.domainLayer.repositories.PublisherRepository;

@Service
public class PublisherService {
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private PublisherRepository publisherRepo;
	
	
	public List<PublisherDto> getPublishers(){
		return publisherRepo.findAll()
				.stream()
				.map(p->PublisherDtoConverter.toDto(p))
				.collect(Collectors.toList());
	}
	
	public PublisherDto getPublisherById(int id) {
		PublisherDto publisher = PublisherDtoConverter.toDto(
				publisherRepo.findById(id).get());
		return publisher;
	}
	
	public int createPublisher(PublisherDto dto) {
		Publisher newPublisher = PublisherDtoConverter.toEntity(dto);
		publisherRepo.save(newPublisher);
		return newPublisher.getId();
	}
	
	public int updatePublisher(PublisherDto dto) {
		Publisher publisher = publisherRepo.findById(dto.getId()).get();
		publisher.setName(dto.getName());
		publisher.setPhone(dto.getPhone());
		publisher.setEmail(dto.getEmail());
		publisherRepo.save(publisher);
		return publisher.getId();
	}
	
	public void addBook(int publisherId, int bookId) {
		Book book = bookRepo.findById(bookId).get();
		Publisher publisher = publisherRepo.findById(publisherId).get();
		publisher.getBooks().add(book);
		publisherRepo.save(publisher);
	}
	
	public void removeBook(int publisherId, int bookId) {
		Book book = bookRepo.findById(bookId).get();
		Publisher publisher = publisherRepo.findById(publisherId).get();
		publisher.getBooks().removeIf(b->b.equals(book));
		publisherRepo.save(publisher);
	}
	
	public List<BookDto> getBooks(int id) {
		Publisher publisher = publisherRepo.findById(id).get();
		List<Book> books = publisher.getBooks();
		List<BookDto> booksdtos = books.stream().map(b->BookDtoConverter.toDto(b)).collect(Collectors.toList());
		return booksdtos;
	}
	
	public void deletePublisher(int publisherId) {
		Publisher publisher = publisherRepo.findById(publisherId).get();
		publisherRepo.delete(publisher);
	}


}
