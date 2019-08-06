package com.nationwide.showing;

import com.nationwide.film.Film;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShowingControllerTest {

    @Autowired
    @InjectMocks
    private ShowingController showingController;

    @Mock
    private ShowingRepository showingRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    static final int noOfshowings = 2;

    @Test
    public void showingConnectionTest() {
        when(showingRepository.findAll()).thenReturn(getShowings());
        assertEquals(noOfshowings, showingRepository.findAll().size());
        this.restTemplate.getForObject("http://localhost:" + port + "/showings", String.class);
    }

    private static List<Showing> getShowings() {
        Showing showing2 = new Showing();
        List<Showing> myList = new ArrayList<>();
        myList.add(newShowing());
        myList.add(showing2);
        return myList;
    }

    private static Showing newShowing() {
        return new Showing("a", "b", "c");
    }

    @Test
    public void findByIdTest() {
        Optional<Showing> optionShowing = Optional.of(newShowing());
        when(showingRepository.findById("a")).thenReturn(optionShowing);
        assertEquals(showingRepository.findById("a"), optionShowing);
        this.restTemplate.getForObject("http://localhost:" + port + "/showings/a", String.class);
    }

    @Test
    public void addNewShowingTest() {
        showingRepository.save(newShowing());
        this.restTemplate.postForEntity("http://localhost:" + port + "/showings", newShowing(), Void.class);
    }

    @Test
    public void updateShowingTest() {
        showingRepository.save(newShowing());
        this.restTemplate.put("http://localhost:" + port + "/showings/a", newShowing(),Void.class);
    }

    @Test
    public void deleteShowingByIdTest() {
        showingRepository.deleteById("a");
        this.restTemplate.delete("http://localhost:" + port + "/showings/a", Void.class);
    }
}
