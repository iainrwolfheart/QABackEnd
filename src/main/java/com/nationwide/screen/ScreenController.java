package com.nationwide.screen;

import java.util.List;
import java.util.Optional;

import com.nationwide.screen.ScreenRepository;
import com.nationwide.screen.Screen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ScreenController {
	
	@Autowired
	private ScreenRepository screenRepository;

	@RequestMapping(value = "/screens", method = RequestMethod.GET)
	public List<Screen> getAllScreens() {
		return screenRepository.findAll();
	}

	@RequestMapping(value = "/screens/{id}", method = RequestMethod.GET)
	public Optional<Screen> getScreenById(@PathVariable("id") String id) {
		return screenRepository.findById(id);
	}

	@RequestMapping(value = "/screens/{id}", method = RequestMethod.PUT)
	public void updateScreen(@PathVariable("id") String id, @RequestBody Screen screen){
		screen.setId(id);
		screenRepository.save(screen);
	}
}