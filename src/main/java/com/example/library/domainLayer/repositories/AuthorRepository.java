package com.example.library.domainLayer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.domainLayer.models.Author;

import jakarta.transaction.Transactional;

@Transactional
public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
