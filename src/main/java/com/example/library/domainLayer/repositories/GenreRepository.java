package com.example.library.domainLayer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.domainLayer.models.Genre;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{

}
