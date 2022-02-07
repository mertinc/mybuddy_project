package com.cengs.mybuddy.resource;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document

public class PetRequest {
	
	private UUID id;
	private String name;
	private int age;
	private String type;//hayvanın türü
	private String breed;//hayvanın cinsi
	private String gender;//cinsiyeti

	public PetRequest(UUID id, String name, int age, String type, String breed, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.type = type;
		this.breed = breed;
		this.gender = gender;
	}
	
}
