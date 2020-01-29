package com.project.postMicroservice.service;


import com.project.postMicroservice.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment save(Comment comment);
    List<Comment> getComment(String postId);
}
