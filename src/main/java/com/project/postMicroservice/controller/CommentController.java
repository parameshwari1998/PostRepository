package com.project.postMicroservice.controller;


import com.project.postMicroservice.dto.BaseResponse;
import com.project.postMicroservice.dto.CommentDto;
import com.project.postMicroservice.entity.Comment;
import com.project.postMicroservice.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class CommentController {

    @Autowired
    CommentService  commentService;

    @PostMapping("/comment")
    public BaseResponse<String> addComment(@RequestBody CommentDto commentDto) {
        Comment commentEntity = new Comment();
        BeanUtils.copyProperties(commentDto, commentEntity);
        BaseResponse<String> baseResponse = new BaseResponse();
        try {
            Comment createdcomment = commentService.save(commentEntity);
            baseResponse.setStatus(true);
        } catch (Exception e) {
            baseResponse.setErrorMessage(e.getMessage());
            baseResponse.setStatus(false);
        }
        return baseResponse;
    }


    public BaseResponse<List<Comment>> getComment(String postId) {
        BaseResponse<List<Comment>> baseResponse = new BaseResponse<>();
        try{
            baseResponse.setData(commentService.getComment(postId));
            baseResponse.setStatus(true);
        }catch (Exception e){
            baseResponse.setStatus(false);
            baseResponse.setErrorMessage("couldnt retrieve");
        }
        return baseResponse;
    }


}
