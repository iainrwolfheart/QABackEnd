package com.nationwide.film;

import java.util.List;
import java.util.Optional;

import com.nationwide.film.FilmRepository;
import com.nationwide.film.Film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://35.246.125.69")
public class FilmController {

	@Autowired
	private FilmRepository filmRepository;

	@RequestMapping(value = "/films", method = RequestMethod.GET)
	public List<Film> getAllFilms() {
		return filmRepository.findAll();
	}

	@RequestMapping(value = "/films/{id}", method = RequestMethod.GET)
	public Optional<Film> getFilmById(@PathVariable("id") String id) {
		return filmRepository.findById(id);
	}

	@RequestMapping(value = "/films", method = RequestMethod.POST)
	public void addNewFilm(@RequestBody Film film){
		filmRepository.save(film);
	}

	@RequestMapping(value = "/films/{id}", method = RequestMethod.PUT)
	public void updateFilm(@PathVariable("id") String id, @RequestBody Film film){
		film.setId(id);
		filmRepository.save(film);
	}

	@RequestMapping(value = "/films/{id}", method = RequestMethod.DELETE)
	public void deleteFilm(@PathVariable("id") String id) {
		filmRepository.deleteById(id);
	}
}
