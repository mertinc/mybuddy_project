package com.cengs.mybuddy.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
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
	private Long phoneNumber;
	private String password;
	public List<Comment> comments = new ArrayList<>();
	public List<Ad> ads= new ArrayList<>();


	public User() {
}
	
	public User(UUID id, String firstName, String lastName, String email, String userName, Long phoneNumber, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
}
	