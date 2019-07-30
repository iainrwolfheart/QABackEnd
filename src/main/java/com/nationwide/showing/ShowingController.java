package com.nationwide.showing;

import java.util.List;
import java.util.Optional;

import com.nationwide.showing.ShowingRepository;
import com.nationwide.showing.Showing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8000")
public class ShowingController {
	
	@Autowired
	private ShowingRepository showingRepository;

	@RequestMapping(value = "/showings", method = RequestMethod.GET)
	public List<Showing> getAllShowings() {
		return showingRepository.findAll();
	}

	@RequestMapping(value = "/showings/{id}", method = RequestMethod.GET)
	public Optional<Showing> getShowingId(@PathVariable("id") String id) {
		return showingRepository.findById(id);
	}

	@RequestMapping(value = "/showings", method = RequestMethod.POST)
	public Showing addNewShowing(@RequestBody Showing showing){
		return showingRepository.save(showing);
	}

	@RequestMapping(value = "/showings/{id}", method = RequestMethod.PUT)
	public Showing updateShowing(@PathVariable("id") String id, @RequestBody Showing showing){
		showing.setId(id);
		return showingRepository.save(showing);
	}

	@RequestMapping(value = "/showings/{id}", method = RequestMethod.DELETE)
	public void deleteShowing(@PathVariable("id") String id) {
		showingRepository.deleteById(id);
	}

}