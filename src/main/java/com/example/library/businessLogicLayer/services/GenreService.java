package com.example.library.businessLogicLayer.services;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.businessLogicLayer.dtos.BookDto;
import com.example.library.businessLogicLayer.dtos.GenreDto;
import com.example.library.businessLogicLayer.dtos.converters.BookDtoConverter;
import com.example.library.businessLogicLayer.dtos.converters.GenreDtoConverter;
import com.example.library.domainLayer.models.Book;
import com.example.library.domainLayer.models.Genre;
import com.example.library.domainLayer.repositories.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository genreRepo;
	
	@Autowired
	private GenreDtoConverter genreDtoConverter;
	
	@Autowired
	private BookDtoConverter bookDtoConverter;
	
	
	public Collection<GenreDto> getGenres(){
		 return genreRepo.findAll()
				.stream()
				.map(g->genreDtoConverter.toDto(g))
				.collect(Collectors.toSet());
	}
	
	public GenreDto getGenreById(int id) {
		GenreDto genre = genreDtoConverter.toDto(
				genreRepo.findById(id).get());
		return genre;
	}
	
	public int createGenre(GenreDto dto) {
		Genre newGenre = genreDtoConverter.toEntity(dto);
		genreRepo.save(newGenre);
		return newGenre.getId();
	}
	
	public int updateGenre(GenreDto dto) {
		Genre genre = genreRepo.findById(dto.getId()).get();
		Genre temp = genreDtoConverter.toEntity(dto);
		genre.setGenre(dto.getGenre());
		genre.setParentGenre(temp.getParentGenre());
		genre.setSubGenres(temp.getSubGenres());
		genre.setBooks(temp.getBooks());
		genreRepo.save(genre);
		return genre.getId();
	}
	
	
	/*addBook, removeBook, getBooks
	 * addSubGenre, removeSubGenre, getSubGenres
	 * addOrReplaceParentGenre, removeParentGenre, getParentGenre
	 * */
	
	public Collection<BookDto> getBooks(int id) {
		Genre genre = genreRepo.findById(id).get();
		Collection<Book> books = genre.getBooks();
		Collection<BookDto> booksdtos = books.stream().map(b->bookDtoConverter.toDto(b)).collect(Collectors.toSet());
		return booksdtos;
	}
	
	public String addSubGenre(int genreId, int subId) {
		Genre genre = genreRepo.findById(genreId).get();
		Genre sub = genreRepo.findById(subId).get();		
		boolean result = genre.getSubGenres().add(sub);
		genreRepo.save(genre);
		return result?"success":"failed";
	}
	
	public String removeSubGenre(int genreId, int subId) {
		Genre genre = genreRepo.findById(genreId).get();
		Genre sub = genreRepo.findById(subId).get();		
		boolean result = genre.getSubGenres().remove(sub);
		genreRepo.save(genre);
		return result?"success":"failed";
	}
	
	public Collection<GenreDto> getSubGenres(int id) {
		Genre genre = genreRepo.findById(id).get();
		Collection<Genre> subgenres = genre.getSubGenres();
		Collection<GenreDto> subgenresdtos = subgenres.stream().map(s->genreDtoConverter.toDto(s)).collect(Collectors.toSet());
		return subgenresdtos;
	}
	
	public String addOrReplaceParentGenre(int genreId, int parentId) {
		Genre genre = genreRepo.findById(genreId).get();
		Genre parent = genreRepo.findById(parentId).get();	
		genre.setParentGenre(parent);
		genreRepo.save(genre);
		return "success";
	}
	
	public String removeParentGenre(int genreId) {
		Genre genre = genreRepo.findById(genreId).get();
		genre.setParentGenre(null);
		genreRepo.save(genre);
		return "success";
	}
	
	public GenreDto getParentGenre(int genreId) {
		Genre genre = genreRepo.findById(genreId).get();
		Genre parent = genre.getParentGenre();
		GenreDto dto = genreDtoConverter.toDto(parent);
		return dto;
	}
	
	public String deleteGenre(int genreId) {
		Genre genre = genreRepo.findById(genreId).get();
		genreRepo.delete(genre);
		return "success";
	}

}
