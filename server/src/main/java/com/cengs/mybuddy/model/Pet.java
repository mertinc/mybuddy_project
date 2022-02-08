package com.cengs.mybuddy.model;


import lombok.Data;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document

public class Pet {

	@Id
	private UUID id;
	private String name;
	private int age;
	private String type;//hayvanın türü
	private String breed;//hayvanın cinsi
	private String gender;//cinsiyeti

	public Pet() {
		}

	public Pet(UUID id, String name, int age, String type, String breed, String gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.type = type;
		this.breed = breed;
		this.gender = gender;
 }
}