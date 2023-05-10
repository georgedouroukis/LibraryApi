package com.example.library.domainLayer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.domainLayer.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
