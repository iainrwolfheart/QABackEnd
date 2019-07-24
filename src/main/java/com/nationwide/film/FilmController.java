package com.nationwide.film;

import java.util.List;

import com.nationwide.constants.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FilmController {
	
	@Autowired
	private FilmService filmService;

	@GetMapping(path = Constants.FILMS)
	public ResponseEntity<List<Film>> getFilms() {
		return ResponseEntity.ok(filmService.getFilms());
	}
}