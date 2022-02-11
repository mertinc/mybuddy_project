package com.cengs.mybuddy.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Data
@Document
public class Comment {
    @Id
    private UUID id;
    @DBRef
    private User user;
    //@DBRef
    private UUID adId;
    private String date;
    private String content;

    public Comment(){

    }
    public Comment(UUID id, User user, String date,String content, UUID adId) {
        this.id = id;
        this.user = user;
        this.adId = adId;
        this.date = date;
        this.content=content;
    }
}

