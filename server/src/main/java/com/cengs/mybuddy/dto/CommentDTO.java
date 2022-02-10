package com.cengs.mybuddy.dto;

import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.cengs.mybuddy.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {
    @Id
    private UUID id;
    @NotNull(message = "user is mandatory")
    private UUID userId;
    //@NotNull(message = "name is mandatory")
    @NotNull(message = "user is mandatory")
    private UUID adId;
    //private String name;
    @NotNull(message = "date is mandatory")
    @JsonFormat(pattern="yyyy-MM-dd",shape= JsonFormat.Shape.STRING)
    private String date;
    @NotNull(message = "content is mandatory")
    private String content;
    //@Id
    //private UUID id;
}