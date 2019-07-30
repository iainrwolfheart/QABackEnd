package com.nationwide.screen;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends MongoRepository<Screen, String> {
	
}