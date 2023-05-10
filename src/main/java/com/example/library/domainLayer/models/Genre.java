package com.example.library.domainLayer.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.transaction.Transactional;


@Entity(name="genre")
public class Genre {
	
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String genre;
	
	@ManyToOne
	@JoinColumn(name="parent_genre")
	private Genre parentGenre;
	
	@OneToMany(mappedBy = "parentGenre")
	private List<Genre> subGenres = new ArrayList<Genre>();
	
	@JsonBackReference
	@ManyToMany(mappedBy = "genres"/* , fetch = FetchType.EAGER */)
	private List<Book> books = new ArrayList<Book>();


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


	public Genre getParentGenre() {
		return parentGenre;
	}


	public void setParentGenre(Genre parentGenre) {
		this.parentGenre = parentGenre;
	}


	public List<Genre> getSubGenres() {
		return subGenres;
	}


	public void setSubGenres(List<Genre> subGenres) {
		this.subGenres = subGenres;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
