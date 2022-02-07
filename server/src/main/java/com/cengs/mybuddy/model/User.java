package com.cengs.mybuddy.model;

import lombok.*;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document // ("users")  db içinde objelerin altında bulunacağı başlık

public class User {
	
	@Id
	private UUID id;
	private String firstName;
	private String lastName;
	private String email;
	
	public User() {
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User(UUID id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
}
	