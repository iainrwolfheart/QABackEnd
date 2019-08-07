package com.nationwide.discussion;

import java.util.List;
import java.util.Optional;

import com.nationwide.discussion.DiscussionRepository;
import com.nationwide.discussion.Discussion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class DiscussionController {

	@Autowired
	private DiscussionRepository discussionRepository;

	@RequestMapping(value = "/discussion", method = RequestMethod.GET)
	public List<Discussion> getAllDiscussions() {
		return discussionRepository.findAll();
	}

	@RequestMapping(value = "/discussion/{id}", method = RequestMethod.GET)
	public Optional<Discussion> getDiscussionById(@PathVariable("id") String id) {
		return discussionRepository.findById(id);
	}

	@RequestMapping(value = "/discussion", method = RequestMethod.POST)
	public Discussion addNewDiscussion(@RequestBody Discussion discussion){
		return discussionRepository.save(discussion);
	}

	@RequestMapping(value = "/discussion/{id}", method = RequestMethod.PUT)
	public Discussion updateDiscussion(@PathVariable("id") String id, @RequestBody Discussion discussion){
		discussion.setId(id);
		return discussionRepository.save(discussion);

	}

	@RequestMapping(value = "/discussion/{id}", method = RequestMethod.DELETE)
	public void deleteDiscussion(@PathVariable("id") String id) {
		discussionRepository.deleteById(id);
	}
}
