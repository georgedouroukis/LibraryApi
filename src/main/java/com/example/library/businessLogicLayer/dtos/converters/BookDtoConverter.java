package com.example.library.businessLogicLayer.dtos.converters;

import java.util.stream.Collectors;


import com.example.library.businessLogicLayer.dtos.BookDto;
import com.example.library.domainLayer.models.Book;

public class BookDtoConverter {
	
	public static BookDto toDto(Book b) {
		
		return new BookDto(
				b.getId(),
				b.getIsbn(),
				b.getTitle(),
				b.getPageNumber(),
				b.getPublicationDate(),
				b.getDescription(),
				b.getPublisher().getId(),
				b.getGenres().stream().map(g->g.getId()).collect(Collectors.toSet()),
				b.getAuthors().stream().map(a->a.getId()).collect(Collectors.toSet()));
		
		
	}
	
	public static Book toEntity(BookDto dto) {

		Book book = new Book();
		book.setIsbn(dto.getIsbn());
		book.setTitle(dto.getTitle());
		book.setPageNumber(dto.getPageNumber());
		book.setPublicationDate(dto.getPublicationDate());
		book.setDescription(dto.getDescription());
		
		
		return book;
	}

}
