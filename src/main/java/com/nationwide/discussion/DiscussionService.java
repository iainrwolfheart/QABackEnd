package com.nationwide.discussion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscussionService {

	@Autowired
	private DiscussionRepository discussionRepository;

	public List<Discussion> getFilms() {
		return discussionRepository.findAll();
	}
}