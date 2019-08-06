package com.nationwide.film;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.Optional;


import java.util.List;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FilmControllerTest {

    @Autowired
    @InjectMocks
    private FilmController filmController;

    @Mock
    private FilmRepository filmRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    static final int noOfFilms = 2;

    @Test
    public void filmConnectionTest() {
      when(filmRepository.findAll()).thenReturn(getFilms());
      assertEquals(noOfFilms, filmRepository.findAll().size());
      this.restTemplate.getForObject("http://localhost:" + port + "/films", String.class);
    }

    private static List<Film> getFilms() {
      Film film2 = new Film();
      List<Film> myList = new ArrayList<>();
      myList.add(newFilm());
      myList.add(film2);
      return myList;
    }

    private static Film newFilm() {
        return new Film("a", "b", "c", "d", "e", "f", "g",
            "h", "i", "j");
    }

    @Test
    public void findByIdTest() {
      Optional<Film> optionFilm = Optional.of(newFilm());
      when(filmRepository.findById("a")).thenReturn(optionFilm);
      assertEquals(filmRepository.findById("a"), optionFilm);
        this.restTemplate.getForObject("http://localhost:" + port + "/films/a", String.class);
    }

    @Test
    public void addNewFilmTest() {
      filmRepository.save(newFilm());
      this.restTemplate.postForEntity("http://localhost:" + port + "/films", newFilm(), Void.class);
    }

    @Test
    public void updateFilmTest() {
        filmRepository.save(newFilm());
        this.restTemplate.put("http://localhost:" + port + "/films/a", newFilm(),Void.class);
    }

    @Test
    public void deleteFilmByIdTest() {
    filmRepository.deleteById("a");
    this.restTemplate.delete("http://localhost:" + port + "/films/a", Void.class);
    }
}
