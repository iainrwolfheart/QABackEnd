package com.nationwide.screen;

import java.util.List;

import com.nationwide.constants.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ScreenController {
	
	@Autowired
	private ScreenService screenService;

	@GetMapping(path = Constants.SCREENS)
	public ResponseEntity<List<Screen>> getScreens() {
		return ResponseEntity.ok(screenService.getScreens());
	}
}