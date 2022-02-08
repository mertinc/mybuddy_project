package com.cengs.mybuddy.repository;

import com.cengs.mybuddy.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
@Autowired 

	User findById(UUID id);

	void deleteById(UUID id);
	
	//Optional<User> findById(UUID id);

}
