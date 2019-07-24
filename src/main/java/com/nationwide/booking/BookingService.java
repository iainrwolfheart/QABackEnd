package com.nationwide.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	public List<Booking> getBookings() {
		return bookingRepository.findAll();
	}
}