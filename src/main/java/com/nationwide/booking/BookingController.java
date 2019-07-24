package com.nationwide.booking;

import java.util.List;

import com.nationwide.constants.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;

	@GetMapping(path = Constants.BOOKINGS)
	public ResponseEntity<List<Booking>> getBookings() {
		return ResponseEntity.ok(bookingService.getBookings());
	}
}