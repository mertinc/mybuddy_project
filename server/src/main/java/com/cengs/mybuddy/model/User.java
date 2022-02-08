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
	private String userName;
	private String password;
	
	public User() {
	}
	
	public User(UUID id, String firstName, String lastName, String email, String userName, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}
}
	