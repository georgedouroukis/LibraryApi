package com.example.library.businessLogicLayer.dtos.converters;

import java.util.stream.Collectors;

import com.example.library.businessLogicLayer.dtos.GenreDto;
import com.example.library.domainLayer.models.Genre;


public class GenreDtoConverter {

	
	public static GenreDto toDto(Genre g) {
		
		return new GenreDto(
				g.getId(),
				g.getGenre(),
				g.getParentGenre().getId(),
				g.getSubGenres().stream().map(genre->genre.getId()).collect(Collectors.toList()),
				g.getBooks().stream().map(b->b.getId()).collect(Collectors.toList()));
		
		
	}
	
	public static Genre toEntity(GenreDto dto) {

		Genre genre = new Genre();
		genre.setGenre(dto.getGenre());
		return genre;
	}
}
