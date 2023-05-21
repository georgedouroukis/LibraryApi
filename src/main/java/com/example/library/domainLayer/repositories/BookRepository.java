package com.example.library.domainLayer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.domainLayer.models.Book;

import jakarta.transaction.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer>{

}
