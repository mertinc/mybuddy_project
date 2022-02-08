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
public class UserDTO {
	@Id
	private UUID id;
	@NotNull(message = "Username is mandatory")
	private String firstName;
	@NotNull(message = "lastName is mandatory")
	private String lastName;
	@NotNull(message = "email is mandatory")
	private String email;
	@NotNull(message = "userName is mandatory")
	private String userName;
	@NotNull(message = "phoneNumber is mandatory")
	private Long phoneNumber;
	@NotNull(message = "password is mandatory")
	private String password;
}
