package com.nationwide.film;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;

	public List<Film> getFilms() {
		return filmRepository.findAll();
	}
}