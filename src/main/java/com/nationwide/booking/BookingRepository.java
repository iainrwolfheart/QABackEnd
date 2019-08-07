package com.nationwide.booking;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {

	List<Booking> findByShowingId(String id);

	Booking getBookingById(String id);
	
}