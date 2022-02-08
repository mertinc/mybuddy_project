package com.cengs.mybuddy.controller;

import com.cengs.mybuddy.dto.CommentDTO;
import com.cengs.mybuddy.dto.UserDTO;
import com.cengs.mybuddy.model.Comment;
import com.cengs.mybuddy.model.User;
import com.cengs.mybuddy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/addComment")
    public CommentDTO addComment(@Valid @RequestBody CommentDTO dto){
        System.out.println("Post CREATE COMMENT tested.");
        System.out.println(dto.getId()+"\n "+dto.getUserId()+"\n "+dto.getDate()+"\n "+dto.getContent());
        return commentService.createComment(dto);
    }

}
