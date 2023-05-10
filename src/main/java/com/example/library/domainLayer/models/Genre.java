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

}
