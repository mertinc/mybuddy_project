package com.cengs.mybuddy.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cengs.mybuddy.dto.PetDTO;
import com.cengs.mybuddy.model.Pet;
import com.cengs.mybuddy.repository.PetRepository;
import com.cengs.mybuddy.repository.UserRepository;

@Service
public class PetService {

	private final PetRepository petRepository;

	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	public PetDTO createPet(PetDTO petDto) {
		Pet existPet = new Pet();
		existPet = petRepository.findById(petDto.getId());
		if(Objects.nonNull(existPet)) {
			throw new RuntimeException("Exist User");
		}
		Pet newPet = new Pet();
		newPet=mapPetDtoToPet(petDto);
		newPet.setId(UUID.randomUUID());
		newPet= petRepository.save(newPet);
		return mapPetDtoToPet(newPet);
		
	}
	
	public List<PetDTO> findAllPet(){
		List<Pet> pets=petRepository.findAll();
//		List<UserDTO>userDTO= new ArrayList<UserDTO>();
//		for(User user:users) {			
//			userDTO.add(mapUserDtoToUser(user));
//		}		
		return pets.stream().map(pet->mapPetDtoToPet(pet)).collect(Collectors.toList());
		
	}
	
	public Pet findById(UUID id){
		
		return petRepository.findById(id);	
	}
	
	public void deletePet(UUID id) {
		petRepository.deleteById(id);
	}

	private Pet mapPetDtoToPet(PetDTO dto) {
		Pet pet = new Pet();
		pet.setId(dto.getId());
		pet.setName(dto.getName());
		//pet.setAge(dto.getAge());
		pet.setType(dto.getType());
		pet.setBreed(dto.getBreed());
		pet.setGender(dto.getGender());
		return pet;
	}

	private PetDTO mapPetDtoToPet(Pet pet) {
		PetDTO dto = new PetDTO();
		dto.setId(pet.getId());
		dto.setName(pet.getName());
		//dto.setAge(pet.getAge());
		dto.setType(pet.getType());
		dto.setBreed(pet.getBreed());
		dto.setGender(pet.getGender());
		return dto;
	}

}
