package com.cengs.mybuddy.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserLoginDTO {

	@NotNull(message = "email is mandatory")
	private String email;
	@NotNull(message = "password is mandatory")
	private String password;
	
}
