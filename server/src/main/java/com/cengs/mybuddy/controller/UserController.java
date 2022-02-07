package com.cengs.mybuddy.controller;


import com.cengs.mybuddy.model.User;
import com.cengs.mybuddy.repository.UserRepository;
import com.cengs.mybuddy.resource.UserRequest;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@RestController
public class UserController {

	private final UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		
		this.userRepository = userRepository;
		
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUsers() {
		
		return ResponseEntity.ok(this.userRepository.findAll());
		
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest){
		System.out.println("Testing of post method");
		User user = new User();
		user.setId(UUID.randomUUID());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setEmail(userRequest.getEmail());
		return ResponseEntity.status(201).body(this.userRepository.save(user));
	
 }
	@GetMapping("/user/{id}")
	public ResponseEntity getAllUsersById(@PathVariable String id) {
		
		Optional <User> user = this.userRepository.findById(id);
		System.out.println("Testing of find by id.");
		System.out.println("User is : " + user);
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		} 
		else {
			return ResponseEntity.ok("The product id : " + id + " was not found.");
		}
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity deleteUserById(@PathVariable String id) {
		
		Optional <User> user = this.userRepository.findById(id);
		System.out.println("Testing of find by id.");
		
		if(user.isPresent()) {
			this.userRepository.deleteById(id);
			return ResponseEntity.ok("Successfuly deleted.");
		} 
		else {
			return ResponseEntity.ok("The product id : " + id + " was not found.");
		}
	}
}
