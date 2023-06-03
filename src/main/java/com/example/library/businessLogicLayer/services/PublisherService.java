package com.example.library.businessLogicLayer.services;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.businessLogicLayer.dtos.BookDto;
import com.example.library.businessLogicLayer.dtos.PublisherDto;
import com.example.library.businessLogicLayer.dtos.converters.BookDtoConverter;
import com.example.library.businessLogicLayer.dtos.converters.PublisherDtoConverter;
import com.example.library.domainLayer.models.Book;
import com.example.library.domainLayer.models.Publisher;
import com.example.library.domainLayer.repositories.PublisherRepository;

@Service
public class PublisherService {
	
	@Autowired
	private PublisherRepository publisherRepo;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private PublisherDtoConverter publisherDtoConverter;
	
	@Autowired
	private BookDtoConverter bookDtoConverter;
	
	
	public Collection<PublisherDto> getPublishers(){
		return publisherRepo.findAll()
				.stream()
				.map(p->publisherDtoConverter.toDto(p))
				.collect(Collectors.toSet());
	}
	
	public PublisherDto getPublisherById(int id) {
		PublisherDto publisher = publisherDtoConverter.toDto(
				publisherRepo.findById(id).get());
		return publisher;
	}
	
	public int createPublisher(PublisherDto dto) {
		Publisher newPublisher = publisherDtoConverter.toEntity(dto);
		publisherRepo.save(newPublisher);
		
		//because mapped by Book::publisher,  the opposite works fine
		for(Book book : newPublisher.getBooks()) {
			bookService.addOrReplacePublisher(book.getId(), newPublisher.getId());
		}
		return newPublisher.getId();
	}
	
	public int updatePublisher(PublisherDto dto) {
		Publisher publisher = publisherRepo.findById(dto.getId()).get();
		Publisher temp = publisherDtoConverter.toEntity(dto);
		publisher.setName(dto.getName());
		publisher.setPhone(dto.getPhone());
		publisher.setEmail(dto.getEmail());
		publisherRepo.save(publisher);
		
		//because mapped by Book::publisher,  the opposite works fine
		for(Book book : publisher.getBooks()) {
			bookService.removePublisher(book.getId());
		}
		for(Book book : temp.getBooks()) {
			bookService.addOrReplacePublisher(book.getId(), publisher.getId());
		}

		return publisher.getId();
	}
	
	public Collection<BookDto> getBooks(int id) {
		Publisher publisher = publisherRepo.findById(id).get();
		Collection<Book> books = publisher.getBooks();
		Collection<BookDto> booksdtos = books.stream().map(b->bookDtoConverter.toDto(b)).collect(Collectors.toSet());
		return booksdtos;
	}
	
	public String deletePublisher(int publisherId) {
		Publisher publisher = publisherRepo.findById(publisherId).get();
		publisherRepo.delete(publisher);
		return "success";
	}

}
