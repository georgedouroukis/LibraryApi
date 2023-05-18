package com.example.library.businessLogicLayer.dtos;

import java.util.ArrayList;
import java.util.List;

public class AuthorDto {
	
	private int id;
	private String firstName;
	private String lastName;
	private String middleName;
	
	private List<Integer> books = new ArrayList<>();
	
	
	public AuthorDto(int id, String firstName, String lastName, String middleName, List<Integer> books) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.books = books;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public List<Integer> getBooks() {
		return books;
	}
	
}
