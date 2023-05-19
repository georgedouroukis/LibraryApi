package com.example.library.businessLogicLayer.dtos.converters;

import java.util.stream.Collectors;

import com.example.library.businessLogicLayer.dtos.PublisherDto;
import com.example.library.domainLayer.models.Publisher;


public class PublisherDtoConverter {
	
	
	public static PublisherDto toDto(Publisher p) {
		
		return new PublisherDto(
				p.getId(),
				p.getName(),
				p.getPhone(),
				p.getEmail(),
				p.getBooks().stream().map(b->b.getId()).collect(Collectors.toList()));
		
		
	}
	
	public static Publisher toEntity(PublisherDto dto) {

		Publisher publisher = new Publisher();
		publisher.setName(dto.getName());
		publisher.setPhone(dto.getPhone());
		publisher.setEmail(dto.getEmail());
		return publisher;
	}

}
