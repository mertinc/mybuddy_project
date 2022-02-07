package com.cengs.mybuddy.resource;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document
public class UserRequest{
	private UUID id;
	private String firstName;
	private String lastName;
	private String email;
	public UserRequest(UUID id, String firstName, String lastName, String email) {
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
}
