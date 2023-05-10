package com.example.library.domainLayer.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


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
	
	
	@ManyToMany(mappedBy = "genres")
	private List<Book> books = new ArrayList<Book>();


	@Override
	public String toString() {
		return "Genre [id=" + id + ", genre=" + genre + ", parentGenre=" + parentGenre + ", subGenres=" + subGenres
				+ ", books=" + books + "]";
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
