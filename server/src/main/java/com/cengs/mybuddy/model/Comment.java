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
    //private Ad ad;
    private Date date;
    private String content;

    public Comment(){

    }
    public Comment(UUID id, User user, Date date,String content) {
        this.id = id;
        this.user = user;
        //this.ad = ad;
        this.date = date;
        this.content=content;
    }
}

