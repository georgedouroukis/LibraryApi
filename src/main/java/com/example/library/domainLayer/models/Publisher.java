package com.example.library.domainLayer.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="publisher")
public class Publisher {
	
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String phone;
	
	private String email;
	
	@OneToMany(mappedBy="publisher")
	private List<Book> books = new ArrayList<Book>();

}
