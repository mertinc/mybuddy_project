package com.cengs.mybuddy.service;

import com.cengs.mybuddy.dto.CommentDTO;
import com.cengs.mybuddy.dto.UserDTO;
import com.cengs.mybuddy.model.Comment;
import com.cengs.mybuddy.model.User;
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
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    public CommentDTO createComment(CommentDTO commentDTO){
        Comment newComment=new Comment();
        newComment=mapCommentDtoToComment(commentDTO);
        newComment.setUser(userService.findById(commentDTO.getUserId()));
        newComment.setId(UUID.randomUUID());
        newComment=commentRepository.save(newComment);
        User tmp = userService.findById(commentDTO.getUserId());
        List<Comment> newComments = new ArrayList<Comment>();
        newComments.add(newComment);
        if(tmp.comments == null)
        {
        	tmp.comments = newComments;
        }
        else
        {

            tmp.comments.add(newComment);
        }
        //(userService.findById(commentDTO.getUserId()))..save((userService.findById(commentDTO.getUserId())));
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
        System.out.println(comment.getUser());
        dto.setUserId(comment.getUser().getId());
        dto.setDate(comment.getDate());
        dto.setContent(comment.getContent());
        return dto;
    }
}
