package com.cengs.mybuddy.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(style = "yyyy-MM-dd")
	@CreatedDate
	private String date;
	@NotNull(message = "explanation is mandatory")
	private String explanation;
	//@NotNull(message = "image is mandatory")
	//private String image;
	@NotNull(message = "phoneNumber is mandatory")
	private String phoneNumber;
	@NotNull(message = "status is mandatory")
	private String status;
	
	private String imageURL;


	@Override
	public String toString() {
		return "AdDTO{" +
				"id=" + id +
				", userId=" + userId +
				", title='" + title + '\'' +
				", date='" + date + '\'' +
				", explanation='" + explanation + '\'' +
				", phoneNumber=" + phoneNumber +
				", status='" + status + '\'' +
				", imageURL='" + imageURL + '\'' +
				'}';
	}

}
