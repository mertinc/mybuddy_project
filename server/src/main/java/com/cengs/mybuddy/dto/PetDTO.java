package com.cengs.mybuddy.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PetDTO {
	@Id
	private UUID id;
	@NotNull(message = "Name is mandatory")
	private String name;
	//@NotNull(message = "name is mandatory")
	//private String name;
	@NotNull(message = "age is mandatory")
	private String age;
	@NotNull(message = "type is mandatory")
	private String type;
	@NotNull(message = "breed is mandatory")
	private String breed;
	@NotNull(message = "gender is mandatory")
	private String gender;
}

