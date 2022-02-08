package com.cengs.mybuddy.resource;

import com.cengs.mybuddy.model.User;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Data
@Document
public class CommentRequest {
    private UUID id;
    @DBRef
    private User user;
    @DBRef
    //private Ad ad;
    private Date date;
    private String content;

    public CommentRequest(UUID id, User user, Date date, String content) {
        this.id = id;
        this.user = user;
        //this.ad = ad;
        this.date = date;
        this.content=content;
    }
}
