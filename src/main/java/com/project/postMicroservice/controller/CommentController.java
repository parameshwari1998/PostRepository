package com.project.postMicroservice.controller;


import com.project.postMicroservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class CommentController {

    @Autowired
    CommentService commentService;



}
