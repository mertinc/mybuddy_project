package com.cengs.mybuddy.repository;

import com.cengs.mybuddy.model.User;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

	//List<User> findAll();
	//List<User> save();

}
