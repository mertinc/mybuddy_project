package com.cengs.mybuddy.repository;

import com.cengs.mybuddy.model.Pet;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.cengs.mybuddy.model.User;

public interface PetRepository extends MongoRepository<Pet, String> {
@Autowired 

	Pet findById(UUID id);
}
