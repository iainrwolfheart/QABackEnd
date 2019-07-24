package com.nationwide.showing;

import java.util.List;

import com.nationwide.constants.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ShowingController {
	
	@Autowired
	private ShowingService showingService;

	@GetMapping(path = Constants.SHOWINGS)
	public ResponseEntity<List<Showing>> getShowings() {
		return ResponseEntity.ok(showingService.getShowings());
	}
}