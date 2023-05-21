package com.example.library.businessLogicLayer.dtos;

import java.util.Collection;
import java.util.HashSet;

public class GenreDto {

	private int id;
	private String genre;
	
	private Integer parentGenre;
	private Collection<Integer> subGenres = new HashSet<Integer>();
	private Collection<Integer> books = new HashSet<Integer>();
	
	
	public GenreDto(int id, String genre, Integer parentGenre, Collection<Integer> subGenres, Collection<Integer> books) {
		super();
		this.id = id;
		this.genre = genre;
		this.parentGenre = parentGenre;
		this.subGenres = subGenres;
		this.books = books;
	}
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
	public Integer getParentGenre() {
		return parentGenre;
	}
	public Collection<Integer> getSubGenres() {
		return subGenres;
	}
	public Collection<Integer> getBooks() {
		return books;
	}
	
	
}
