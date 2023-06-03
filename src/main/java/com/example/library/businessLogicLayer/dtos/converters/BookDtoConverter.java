package com.example.library.businessLogicLayer.dtos.converters;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.businessLogicLayer.dtos.BookDto;
import com.example.library.domainLayer.models.Author;
import com.example.library.domainLayer.models.Book;
import com.example.library.domainLayer.models.Genre;
import com.example.library.domainLayer.repositories.AuthorRepository;
import com.example.library.domainLayer.repositories.GenreRepository;
import com.example.library.domainLayer.repositories.PublisherRepository;

@Service
public class BookDtoConverter {
	
	@Autowired
	private PublisherRepository publisherRepo;
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@Autowired
	private GenreRepository genreRepo;
	
	
	
	public BookDto toDto(Book b) {
		
		return new BookDto(
				b.getId(),
				b.getIsbn(),
				b.getTitle(),
				b.getPageNumber(),
				b.getPublicationDate(),
				b.getDescription(),
				b.getImageUrl(),
				(b.getPublisher()==null)?null:b.getPublisher().getId(),
				b.getGenres().stream().map(g->g.getId()).collect(Collectors.toSet()),
				b.getAuthors().stream().map(a->a.getId()).collect(Collectors.toSet()));
		
		
	}
	
	public Book toEntity(BookDto dto) {

		Book book = new Book();
		book.setIsbn(dto.getIsbn());
		book.setTitle(dto.getTitle());
		book.setPageNumber(dto.getPageNumber());
		book.setPublicationDate(dto.getPublicationDate());
		book.setDescription(dto.getDescription());
		book.setImageUrl(dto.getImageUrl());
		if(dto.getPublisher()!=null)
			book.setPublisher(publisherRepo.findById(dto.getPublisher()).get());
		Set<Author> authors = dto.getAuthors().stream().map(authorId-> authorRepo.findById(authorId).get()).collect(Collectors.toSet());
		book.setAuthors(authors);
		Set<Genre> genres = dto.getGenres().stream().map(genreId-> genreRepo.findById(genreId).get()).collect(Collectors.toSet());
		book.setGenres(genres);
		
		return book;
	}

}
