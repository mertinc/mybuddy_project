package com.cengs.mybuddy.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cengs.mybuddy.dto.PetDTO;
import com.cengs.mybuddy.model.Pet;
import com.cengs.mybuddy.dto.UserDTO;
import com.cengs.mybuddy.service.PetService;

@RestController
@Validated
@RequestMapping("/pets")
public class PetController {
	
	@Autowired
	PetService petService;
	
	@PostMapping("/addPet")
	public PetDTO addPet(@Valid @RequestBody PetDTO dto) {
		return petService.createPet(dto);
	}
		
	@DeleteMapping("/deletePet/{id}")
	public void deletePet(@PathVariable("id") UUID id) {
		petService.deletePet(id);
	}
	
	@GetMapping("/findAll")
	public List<PetDTO> findAll(){
		return petService.findAllPet();		
	}
	
	
}
