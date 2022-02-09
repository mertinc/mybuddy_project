package com.cengs.mybuddy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Ad {
	@Id
	private UUID id;
	@DBRef  //
	private User user;
	private String date;
	private String title;
	private String explanation;
	private String image;
	private Long phoneNumber;
	private String status;
	public List<Comment> comments = new ArrayList<>();
	//private List<Ad> ads;

	public Ad() {
}
	public Ad(UUID id, String date, String title, String explanation, String image, Long phoneNumber, String status,List<Comment> comments,User user) {
		this.id = id;
		this.user = user;
		this.date = date;
		this.title = title;
		this.explanation = explanation;
		this.image = image;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.comments = comments;
	}
}
