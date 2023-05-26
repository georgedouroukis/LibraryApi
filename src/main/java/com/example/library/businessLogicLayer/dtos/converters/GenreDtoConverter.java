package com.example.library.businessLogicLayer.dtos.converters;

import java.util.stream.Collectors;

import com.example.library.businessLogicLayer.dtos.GenreDto;
import com.example.library.domainLayer.models.Genre;


public class GenreDtoConverter {

	
	public static GenreDto toDto(Genre g) {
		
		return new GenreDto(
				g.getId(),
				g.getGenre(),
				(g.getParentGenre()==null)?null:g.getParentGenre().getId(),
				g.getSubGenres().stream().map(genre->genre.getId()).collect(Collectors.toSet()),
				g.getBooks().stream().map(b->b.getId()).collect(Collectors.toSet()));
		
		
	}
	
	public static Genre toEntity(GenreDto dto) {

		Genre genre = new Genre();
		genre.setGenre(dto.getGenre());
		return genre;
	}
}
