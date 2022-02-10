package com.cengs.mybuddy.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cengs.mybuddy.dto.UserDTO;
import com.cengs.mybuddy.dto.UserLoginDTO;
import com.cengs.mybuddy.model.User;
import com.cengs.mybuddy.repository.UserRepository;


@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserDTO createUser(UserDTO userDto) {
		/*User existUser = new User();
		Optional<User> optUser;
		optUser = userRepository.findById(userDto.getId());
		if(optUser.isEmpty()) {
			throw new RuntimeException("Exist User");
		}*/
		//exisstUser=optUser.get();
		User newUser = new User();
		newUser=mapUserDtoToUser(userDto);
		newUser.setId(UUID.randomUUID());
		System.out.println(newUser.getId());
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
		
		return userRepository.findById(id).get();	
	}
	
	public void deleteUser(UUID id) {
		userRepository.deleteById(id);
	}
	public String userByEmail(UserLoginDTO loginDTO){
        User loggedUser = new User();
        loggedUser.setEmail(loginDTO.getEmail());
        loggedUser.setPassword(loginDTO.getPassword());
        String match = userRepository.findByEmailAndPassword(loggedUser.getEmail(), loggedUser.getPassword());
        if(match != null){
            return "true";
        }
        	return "false";
    }

	private User mapUserDtoToUser(UserDTO dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		user.setUserName(dto.getUserName());
		user.setPassword(dto.getPassword());
		user.setPhoneNumber(dto.getPhoneNumber());
		return user;
	}

	private UserDTO mapUserDtoToUser(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setLastName(user.getLastName());
		dto.setFirstName(user.getFirstName());
		dto.setUserName(user.getUserName());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setPhoneNumber(user.getPhoneNumber());
		return dto;
	}

	

}
