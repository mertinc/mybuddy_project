package com.cengs.mybuddy.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cengs.mybuddy.dto.UserDTO;
import com.cengs.mybuddy.model.User;
import com.cengs.mybuddy.repository.UserRepository;


@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserDTO createUser(UserDTO userDto) {
		User existUser = new User();
		existUser = userRepository.findById(userDto.getId());
		if(Objects.nonNull(existUser)) {
			throw new RuntimeException("Exist User");
		}
		User newUser = new User();
		newUser=mapUserDtoToUser(userDto);
		newUser.setId(UUID.randomUUID());
		newUser= userRepository.save(newUser);
		return mapUserDtoToUser(newUser);
	}
	
	public List<UserDTO> findAllUser(){
		List<User> users=userRepository.findAll();
//		List<UserDTO>userDTO= new ArrayList<UserDTO>();
//		for(User user:users) {			
//			userDTO.add(mapUserDtoToUser(user));
//		}		
		return users.stream().map(user->mapUserDtoToUser(user)).collect(Collectors.toList());
		
	}
	
	public User findById(UUID id){
		
		return userRepository.findById(id);
		
	}

	private User mapUserDtoToUser(UserDTO dto) {
		User user = new User();
		dto.setId(user.getId());
		user.setFirstName(dto.getFirstName());
		//user.setUsername(dto.getUsername());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		return user;
	}

	private UserDTO mapUserDtoToUser(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setLastName(user.getLastName());
		dto.setFirstName(user.getFirstName());
	//	dto.setUsername(user.getUsername());
		dto.setEmail(user.getEmail());
		return dto;
	}

}
