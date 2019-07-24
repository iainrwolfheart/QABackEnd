package com.nationwide.showing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowingService {

	@Autowired
	private ShowingRepository showingRepository;

	public List<Showing> getShowings() {
		return showingRepository.findAll();
	}
}