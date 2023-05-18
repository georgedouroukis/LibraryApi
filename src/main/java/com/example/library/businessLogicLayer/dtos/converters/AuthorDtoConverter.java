package com.example.library.businessLogicLayer.dtos.converters;

import java.util.stream.Collectors;

import com.example.library.businessLogicLayer.dtos.AuthorDto;
import com.example.library.domainLayer.models.Author;

public class AuthorDtoConverter {

	public static AuthorDto toDto(Author a) {
		
		return new AuthorDto(
				a.getId(),
				a.getFirstName(),
				a.getLastName(),
				a.getMiddleName(),
				a.getBooks().stream().map(b->b.getId()).collect(Collectors.toList()));
		
		
	}
}
