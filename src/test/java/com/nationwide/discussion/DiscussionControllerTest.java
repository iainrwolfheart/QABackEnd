package com.nationwide.discussion;

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
public class DiscussionControllerTest {

    @Autowired
    @InjectMocks
    private DiscussionController discussionController;

    @Mock
    private DiscussionRepository discussionRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    static final int noOfDiscussions = 2;

    @Test
    public void discussionConnectionTest() {
      when(discussionRepository.findAll()).thenReturn(getDiscussions());
      assertEquals(noOfDiscussions, discussionRepository.findAll().size());
      this.restTemplate.getForObject("http://localhost:" + port + "/discussion", String.class);
    }

    private static List<Discussion> getDiscussions() {
        Discussion discussion2 = new Discussion();
      List<Discussion> myList = new ArrayList<>();
      myList.add(newDiscussion());
      myList.add(discussion2);
      return myList;
    }

    private static Discussion newDiscussion() {
        return new Discussion("a", "b", "c", "d", "e", "f");
    }

    @Test
    public void findByIdTest() {
      Optional<Discussion> optionDiscussion = Optional.of(newDiscussion());
      when(discussionRepository.findById("a")).thenReturn(optionDiscussion);
      assertEquals(discussionRepository.findById("a"), optionDiscussion);
        this.restTemplate.getForObject("http://localhost:" + port + "/discussion/a", String.class);
    }

    @Test
    public void addNewDiscussionTest() {
        discussionRepository.save(newDiscussion());
      this.restTemplate.postForEntity("http://localhost:" + port + "/discussion", newDiscussion(), Void.class);
    }

    @Test
    public void updateDiscussionTest() {
        discussionRepository.save(newDiscussion());
        this.restTemplate.put("http://localhost:" + port + "/discussion/a", newDiscussion(),Void.class);
    }

    @Test
    public void deleteDiscussionByIdTest() {
        discussionRepository.deleteById("a");
    this.restTemplate.delete("http://localhost:" + port + "/discussion/a", Void.class);
    }
}
