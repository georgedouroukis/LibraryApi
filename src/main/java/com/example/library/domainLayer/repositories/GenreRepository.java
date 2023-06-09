package com.example.library.domainLayer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.domainLayer.models.Genre;

import jakarta.transaction.Transactional;

@Transactional
public interface GenreRepository extends JpaRepository<Genre, Integer>{

}
