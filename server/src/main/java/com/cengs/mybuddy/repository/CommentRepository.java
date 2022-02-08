package com.cengs.mybuddy.repository;

import com.cengs.mybuddy.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository <Comment, String> {

}
