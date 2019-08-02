package com.nationwide.showing;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowingRepository extends MongoRepository<Showing, String> {

	List<Showing> findAllByFilmId(String id);
	
}