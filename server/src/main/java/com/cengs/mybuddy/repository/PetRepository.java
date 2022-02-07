package com.cengs.mybuddy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cengs.mybuddy.model.Pet;

public interface PetRepository extends MongoRepository<Pet, String> {

}
