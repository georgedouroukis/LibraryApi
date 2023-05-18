package com.example.library.businessLogicLayer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.businessLogicLayer.dtos.GenreDto;
import com.example.library.domainLayer.repositories.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository repo;
	
	public List<GenreDto> getGenres(){
		return null;
		
	}
	
	public GenreDto getGenreById() {
		return null;
	}
	
	public void createGenre() {
		
	}
	
	public void updateGenre() {
		
	}
	
	public void deleteGenre() {
		
	}

}
