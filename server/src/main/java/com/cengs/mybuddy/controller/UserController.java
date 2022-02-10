package com.cengs.mybuddy.controller;


import com.cengs.mybuddy.dto.UserDTO;
import com.cengs.mybuddy.model.User;
import com.cengs.mybuddy.repository.UserRepository;
import com.cengs.mybuddy.resource.UserRequest;
import com.cengs.mybuddy.service.UserService;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import javax.validation.Valid;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public UserDTO addUser(@Valid @RequestBody UserDTO dto) {
		System.out.println("Post tested.");
		return userService.createUser(dto);
	}
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable("id") UUID id) {
		userService.deleteUser(id);
		
	}
	
	@GetMapping("/findAll")
	public List<UserDTO> findAll(){
		return userService.findAllUser();		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") UUID id){
		return ResponseEntity.ok(userService.findById(id));		
	}
}
