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
    private AdService adService;

    public CommentService(CommentRepository commentRepository, AdRepository adRepository, AdService adService) {
        this.commentRepository = commentRepository;
        this.adRepository = adRepository;
        this.adService = adService;
    }

    public CommentDTO createComment(CommentDTO commentDTO){
        Comment newComment=new Comment();
        User user1 = userService.findById(commentDTO.getUserId());
        System.out.println("user: "+user1);
        System.out.println("getAdId: "+commentDTO.getAdId());
        Ad ad1 = adService.findById(commentDTO.getAdId());
        System.out.println("ad: "+ad1);
        newComment=mapCommentDtoToComment(commentDTO);
        newComment.setUser(userService.findById(commentDTO.getUserId()));
        newComment.setId(UUID.randomUUID());
        newComment=commentRepository.save(newComment);
        System.out.println("Comment Saved");
        ad1.getComments().add(newComment);
        ad1=adRepository.save(ad1);

        return mapCommentDtoToComment(newComment);
    }


    private Comment mapCommentDtoToComment(CommentDTO dto) {
        Comment comment = new Comment();
        comment.setId(dto.getId());
        comment.setUser(userService.findById(dto.getUserId()));
        comment.setAdId(dto.getAdId());
        comment.setDate(dto.getDate());
        comment.setContent(dto.getContent());
        return comment;
    }

    private CommentDTO mapCommentDtoToComment(Comment comment) {
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        //System.out.println(comment.getUser());
        dto.setAdId(comment.getAdId());
        dto.setUserId(comment.getUser().getId());
        dto.setDate(comment.getDate());
        dto.setContent(comment.getContent());
        return dto;
    }
}
