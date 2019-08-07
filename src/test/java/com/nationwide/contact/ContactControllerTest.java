package com.nationwide.contact;

import com.nationwide.film.Film;
import com.nationwide.film.FilmController;
import com.nationwide.film.FilmRepository;
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
public class ContactControllerTest {

    @Autowired
    @InjectMocks
    private ContactController contactController;

    @Mock
    private ContactRepository contactRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    static final int noOfContacts = 2;

    @Test
    public void contactConnectionTest() {
      when(contactRepository.findAll()).thenReturn(getContacts());
      assertEquals(noOfContacts, contactRepository.findAll().size());
      this.restTemplate.getForObject("http://localhost:" + port + "/contactus", String.class);
    }

    private static List<Contact> getContacts() {
        Contact contact2 = new Contact();
      List<Contact> myList = new ArrayList<>();
      myList.add(newContact());
      myList.add(contact2);
      return myList;
    }

    private static Contact newContact() {
        return new Contact("a", "b", "c", "d", "e");
    }

    @Test
    public void findByIdTest() {
      Optional<Contact> optionContact = Optional.of(newContact());
      when(contactRepository.findById("a")).thenReturn(optionContact);
      assertEquals(contactRepository.findById("a"), optionContact);
        this.restTemplate.getForObject("http://localhost:" + port + "/contactus/a", String.class);
    }

    @Test
    public void addNewContactTest() {
        contactRepository.save(newContact());
      this.restTemplate.postForEntity("http://localhost:" + port + "/contactus", newContact(), Void.class);
    }

    @Test
    public void updateContactTest() {
        contactRepository.save(newContact());
        this.restTemplate.put("http://localhost:" + port + "/contactus/a", newContact(),Void.class);
    }

    @Test
    public void deleteContactByIdTest() {
        contactRepository.deleteById("a");
    this.restTemplate.delete("http://localhost:" + port + "/contactus/a", Void.class);
    }
}
