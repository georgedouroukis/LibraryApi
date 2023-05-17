package com.example.library.businessLogicLayer.dtos;

import java.util.ArrayList;
import java.util.List;

public class GenreDto {

	private int id;
	private String genre;
	
	private GenreDto parentGenre;
	private List<GenreDto> subGenres = new ArrayList<GenreDto>();
	private List<BookDto> books = new ArrayList<BookDto>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public GenreDto getParentGenre() {
		return parentGenre;
	}
	public void setParentGenre(GenreDto parentGenre) {
		this.parentGenre = parentGenre;
	}
	public List<GenreDto> getSubGenres() {
		return subGenres;
	}
	public void setSubGenres(List<GenreDto> subGenres) {
		this.subGenres = subGenres;
	}
	public List<BookDto> getBooks() {
		return books;
	}
	public void setBooks(List<BookDto> books) {
		this.books = books;
	}
	
}
