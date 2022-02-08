package com.cengs.mybuddy.model;

import lombok.*;

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
	private Integer phoneNumber;
	private String password;
	private List<Comment> comments;
	//private List<Ad> ads;


	public User() {
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.comments = comments;

	}
	
	public User(UUID id, String firstName, String lastName, String email, String userName, Integer phoneNumber, String password, List<Comment> comments) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.comments = comments;
	}
}
	