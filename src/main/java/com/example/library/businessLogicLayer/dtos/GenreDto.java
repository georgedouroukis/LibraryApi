package com.example.library.businessLogicLayer.dtos;

import java.util.ArrayList;
import java.util.List;

public class GenreDto {

	private int id;
	private String genre;
	
	private Integer parentGenre;
	private List<Integer> subGenres = new ArrayList<Integer>();
	private List<Integer> books = new ArrayList<Integer>();
	
	
	public GenreDto(int id, String genre, Integer parentGenre, List<Integer> subGenres, List<Integer> books) {
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
	public List<Integer> getSubGenres() {
		return subGenres;
	}
	public List<Integer> getBooks() {
		return books;
	}
	
	
}
