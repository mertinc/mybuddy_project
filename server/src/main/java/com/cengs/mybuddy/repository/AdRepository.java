package com.cengs.mybuddy.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.cengs.mybuddy.model.Ad;
import com.cengs.mybuddy.model.User;

public interface AdRepository extends MongoRepository<Ad, UUID> {
@Autowired

	Optional<Ad> findById(UUID id);
	
	void deleteById(UUID id);
}
