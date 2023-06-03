package com.example.library.businessLogicLayer.dtos.converters;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.businessLogicLayer.dtos.GenreDto;
import com.example.library.domainLayer.models.Book;
import com.example.library.domainLayer.models.Genre;
import com.example.library.domainLayer.repositories.BookRepository;
import com.example.library.domainLayer.repositories.GenreRepository;

@Service
public class GenreDtoConverter {

	@Autowired
	private GenreRepository genreRepo;
	
	@Autowired
	private BookRepository bookRepo;
	
	public GenreDto toDto(Genre g) {
		
		return new GenreDto(
				g.getId(),
				g.getGenre(),
				(g.getParentGenre()==null)?null:g.getParentGenre().getId(),
				g.getSubGenres().stream().map(genre->genre.getId()).collect(Collectors.toSet()),
				g.getBooks().stream().map(b->b.getId()).collect(Collectors.toSet()));
		
		
	}
	
	public Genre toEntity(GenreDto dto) {

		Genre genre = new Genre();
		genre.setGenre(dto.getGenre());
		if (dto.getParentGenre()!=null)
			genre.setParentGenre(genreRepo.findById(dto.getParentGenre()).get());
		Set<Genre> subGenres = dto.getSubGenres().stream().map(subId->genreRepo.findById(subId).get()).collect(Collectors.toSet());
		genre.setSubGenres(subGenres);
		Set<Book> books = dto.getBooks().stream().map(bookId->bookRepo.findById(bookId).get()).collect(Collectors.toSet());
		genre.setBooks(books);
		return genre;
	}
}
