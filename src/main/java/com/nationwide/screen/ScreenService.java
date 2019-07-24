package com.nationwide.screen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenService {

	@Autowired
	private ScreenRepository screenRepository;

	public List<Screen> getScreens() {
		return screenRepository.findAll();
	}
}