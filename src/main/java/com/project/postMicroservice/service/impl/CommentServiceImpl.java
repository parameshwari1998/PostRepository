package com.project.postMicroservice.service.impl;

import com.project.postMicroservice.entity.Comment;
import com.project.postMicroservice.repository.CommentRepository;
import com.project.postMicroservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;


    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getComment(String postId) {
        return commentRepository.findByPostId(postId);
    }

    
}
