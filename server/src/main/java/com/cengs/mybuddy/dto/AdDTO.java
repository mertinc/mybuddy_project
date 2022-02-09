package com.cengs.mybuddy.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdDTO {
	@Id
	private UUID id;
	@NotNull(message = "title is mandatory")
	private UUID userId;
	private String title;
	@NotNull(message = "date is mandatory")
	@JsonFormat(pattern="yyyy-MM-dd",shape= JsonFormat.Shape.STRING)
	private String date;
	@NotNull(message = "explanation is mandatory")
	private String explanation;
	@NotNull(message = "image is mandatory")
	private String image;
	@NotNull(message = "phoneNumber is mandatory")
	private Long phoneNumber;
	@NotNull(message = "status is mandatory")
	private String status;

}
