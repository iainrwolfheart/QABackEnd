package com.nationwide.booking;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.nationwide.booking.BookingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.util.JSON;
import com.nationwide.booking.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "")
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

	@RequestMapping(value = "/bookings/showing/{id}", method = RequestMethod.GET)
	public List<Booking> getBookingByShowingId(@PathVariable("id") String id) {
		return bookingRepository.findByShowingId(id);
	}

	@RequestMapping(value = "/bookings", method = RequestMethod.POST)
	public void addNewBooking(@RequestBody Booking booking){
		bookingRepository.save(booking);
	}

	@RequestMapping(value = "/bookings/{id}", method = RequestMethod.PUT)
	public void updateBooking(@PathVariable("id") String id, @RequestBody Booking booking){
		booking.setId(id);
		bookingRepository.save(booking);
	}

	@RequestMapping(value = "/bookings/{id}/setseats", method = RequestMethod.POST)
	public Booking setSeats(@PathVariable("id") String id, @RequestBody Map<String, String[]> payload){
		// String[] seats = payload.get("seatIds");

		Booking existingBooking = bookingRepository.getBookingById(id);
		existingBooking.setSeatIds(payload.get("seatIds"));
		return bookingRepository.save(existingBooking);
	}

	@RequestMapping(value = "/bookings/{id}/confirm", method = RequestMethod.POST)
	public Booking finaliseBooking(@PathVariable("id") String id, @RequestBody Map<String, Object> payload){
		Booking existingBooking = bookingRepository.getBookingById(id);
		existingBooking.setFirstName(payload.get("firstName").toString());
		existingBooking.setLastName(payload.get("lastName").toString());
		existingBooking.setEmail(payload.get("email").toString());
		Boolean paid = Boolean.parseBoolean(payload.get("paid").toString());
		existingBooking.setPaid(paid);
		Boolean cancelled = Boolean.parseBoolean(payload.get("cancelled").toString());
		existingBooking.setCancelled(cancelled);

		return bookingRepository.save(existingBooking);
	}

	@RequestMapping(value = "/bookings/{id}", method = RequestMethod.DELETE)
	public void deleteBooking(@PathVariable("id") String id) {
		bookingRepository.deleteById(id);
	}
}
