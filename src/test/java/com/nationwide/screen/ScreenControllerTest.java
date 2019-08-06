package com.nationwide.screen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ScreenControllerTest {

    @Autowired
    @InjectMocks
    private ScreenController screenController;

    @Mock
    private ScreenRepository screenRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    static final int noOfScreens = 2;

    @Test
    public void filmConnectionTest() {
        when(screenRepository.findAll()).thenReturn(getScreens());
        assertEquals(noOfScreens, screenRepository.findAll().size());
        this.restTemplate.getForObject("http://localhost:" + port + "/screens", String.class);
    }

    private static List<Screen> getScreens() {
        Screen screen2 = new Screen();
        List<Screen> myList = new ArrayList<>();
        myList.add(newScreen());
        myList.add(screen2);
        return myList;
    }

    private static Screen newScreen() {
        return new Screen("a", new List<List<String>>() {
            @Override
            public int size() {
                return 1;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<List<String>> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(List<String> strings) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends List<String>> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends List<String>> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public List<String> get(int index) {
                return null;
            }

            @Override
            public List<String> set(int index, List<String> element) {
                return null;
            }

            @Override
            public void add(int index, List<String> element) {

            }

            @Override
            public List<String> remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<List<String>> listIterator() {
                return null;
            }

            @Override
            public ListIterator<List<String>> listIterator(int index) {
                return null;
            }

            @Override
            public List<List<String>> subList(int fromIndex, int toIndex) {
                return null;
            }
        });
    }

    @Test
    public void findByIdTest() {
        Optional<Screen> optionScreen = Optional.of(newScreen());
        when(screenRepository.findById("a")).thenReturn(optionScreen);
        assertEquals(screenRepository.findById("a"), optionScreen);
        this.restTemplate.getForObject("http://localhost:" + port + "/screens/a", String.class);
    }

    @Test
    public void addNewScreenTest() {
        screenRepository.save(newScreen());
        this.restTemplate.postForEntity("http://localhost:" + port + "/screens", newScreen(), Void.class);
    }

    @Test
    public void updateScreenTest() {
        screenRepository.save(newScreen());
        this.restTemplate.put("http://localhost:" + port + "/screens/a", newScreen(),Void.class);
    }

    @Test
    public void deleteScreenByIdTest() {
        screenRepository.deleteById("a");
    this.restTemplate.delete("http://localhost:" + port + "/screens/a", Void.class);
    }
}
