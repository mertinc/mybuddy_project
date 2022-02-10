package com.cengs.mybuddy.service;

import com.cengs.mybuddy.dto.CommentDTO;
import com.cengs.mybuddy.dto.UserDTO;
import com.cengs.mybuddy.model.Ad;
import com.cengs.mybuddy.model.Comment;
import com.cengs.mybuddy.model.User;
import com.cengs.mybuddy.repository.AdRepository;
import com.cengs.mybuddy.repository.CommentRepository;
import com.cengs.mybuddy.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private UserService userService;
    private final CommentRepository commentRepository;
    private final AdRepository adRepository;

    public CommentService(CommentRepository commentRepository, AdRepository adRepository) {
        this.commentRepository = commentRepository;
        this.adRepository = adRepository;
    }

    public CommentDTO createComment(CommentDTO commentDTO){
        Comment newComment=new Comment();
        User user = new User();
        Ad ad = new Ad();
        
        user=userService.findById(commentDTO.getUserId());
        newComment=mapCommentDtoToComment(commentDTO);
        newComment.setUser(userService.findById(commentDTO.getUserId()));
        newComment.setId(UUID.randomUUID());
        newComment=commentRepository.save(newComment);
        System.out.println("Comment Saved");
        ad.getComments().add(newComment);
        ad=adRepository.save(ad);
        
        return mapCommentDtoToComment(newComment);
    }


    private Comment mapCommentDtoToComment(CommentDTO dto) {
        Comment comment = new Comment();
        comment.setId(dto.getId());
        comment.setUser(userService.findById(dto.getUserId()));
        comment.setDate(dto.getDate());
        comment.setContent(dto.getContent());
        return comment;
    }

    private CommentDTO mapCommentDtoToComment(Comment comment) {
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        //System.out.println(comment.getUser());
        dto.setUserId(comment.getUser().getId());
        dto.setDate(comment.getDate());
        dto.setContent(comment.getContent());
        return dto;
    }
}
