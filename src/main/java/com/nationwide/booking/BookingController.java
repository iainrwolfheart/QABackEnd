package com.nationwide.booking;

import java.util.List;
import java.util.Optional;

import com.nationwide.booking.BookingRepository;
import com.nationwide.booking.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8000")
public class BookingController {
	
	@Autowired
	private BookingRepository bookingRepository;

	@RequestMapping(value = "/bookings", method = RequestMethod.GET) //file paths TBC
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	@RequestMapping(value = "/bookings/{id}", method = RequestMethod.GET)
	public Optional<Booking> getBookingById(@PathVariable("id") String id) {
		return bookingRepository.findById(id);
	}

	@RequestMapping(value = "/bookings", method = RequestMethod.POST)
	public Booking addNewBooking(@RequestBody Booking booking){
		return bookingRepository.save(booking);
	}

	@RequestMapping(value = "/bookings/{id}", method = RequestMethod.PUT)
	public Booking updateBooking(@PathVariable("id") String id, @RequestBody Booking booking){
		booking.setId(id);
		return bookingRepository.save(booking);
	}

	@RequestMapping(value = "/bookings/{id}", method = RequestMethod.DELETE)
	public void deleteBooking(@PathVariable("id") String id) {
		bookingRepository.deleteById(id);
	}
}