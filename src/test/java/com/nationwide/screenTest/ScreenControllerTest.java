//package com.nationwide.screenTest;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.test.context.junit4.SpringRunner;
//import static org.mockito.Mockito.*;
//import static org.junit.Assert.*;
//import com.nationwide.screen.Screen;
//import com.nationwide.screen.ScreenController;
//import com.nationwide.screen.ScreenRepository;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import java.util.Optional;
//
//
//import java.util.List;
//import java.util.ArrayList;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class ScreenControllerTest {
//
//    @Autowired
//    @InjectMocks
//    private ScreenController screenController;
//
//    @Mock
//    private ScreenRepository screenRepository;
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    static final int noOfScreens = 2;
//
//    @Test
//    public void filmConnectionTest() {
//      when(screenRepository.findAll()).thenReturn(getScreens());
//      assertEquals(noOfScreens, screenRepository.findAll().size());
//      this.restTemplate.getForObject("http://localhost:" + port + "/films", String.class);
//    }
//
//    private static List<Screen> getScreens() {
//      Screen screen = new Screen("a", "b");
//      Screen screen2 = new Screen();
//      List<Screen> myList = new ArrayList<>();
//      myList.add(screen);
//      myList.add(screen2);
//      return myList;
//    }
//
//    @Test
//    public void findByIdTest() {
//      Optional<Screen> optionScreen = Optional.of(new Screen("a", "b"));
//      when(screenRepository.findById("a")).thenReturn(optionScreen);
//      assertEquals(screenRepository.findById("a"), optionScreen);
//    }
//
//    @Test
//    public void addNewFilmTest() {
//      Screen newScreen = new Screen("a", "b");
//      screenRepository.save(newScreen);
//      this.restTemplate.postForEntity("http://localhost:" + port + "/screens/1", newScreen, Void.class);
//    }
//
//    @Test
//    public void deleteFilmByIdTest() {
//        screenRepository.deleteById("a");
//    this.restTemplate.delete("http://localhost:" + port + "/screens/a", Void.class);
//    }
//}
