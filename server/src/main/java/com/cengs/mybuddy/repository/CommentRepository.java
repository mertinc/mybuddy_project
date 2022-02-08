package com.cengs.mybuddy.repository;

import com.cengs.mybuddy.model.Comment;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository <Comment, UUID> {

}
