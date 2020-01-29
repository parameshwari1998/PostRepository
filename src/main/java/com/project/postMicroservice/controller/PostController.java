package com.project.postMicroservice.controller;


import com.project.postMicroservice.dto.BaseResponse;
import com.project.postMicroservice.dto.PostDto;
import com.project.postMicroservice.entity.Post;
import com.project.postMicroservice.service.PostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    CommentController commentController;

    @PostMapping("/createPost")
    public BaseResponse<Post> createPost(@RequestBody PostDto postDto){
        Post post=new Post();
        BeanUtils.copyProperties(postDto,post);
        BaseResponse<Post> baseResponse=new BaseResponse<>();
        try {
            baseResponse.setData(postService.createPost(post));
            baseResponse.setStatus(true);
        }catch (Exception e){
            baseResponse.setErrorMessage(e.getMessage());
            baseResponse.setStatus(false);
        }
        return baseResponse;
    }


    @GetMapping("/getUserPost")
    BaseResponse<List<Post>> getUserPost(@RequestHeader("userId") String userId){
        BaseResponse<List<Post>> baseResponse=new BaseResponse<>();
        try {
            baseResponse.setData(postService.getPostOfUser(userId));
            baseResponse.setStatus(true);
        }catch (Exception e){
            baseResponse.setErrorMessage(e.getMessage());
            baseResponse.setStatus(false);
        }
        return baseResponse;
    }

    @GetMapping("/getPost")
    BaseResponse<Post> getPost(@RequestHeader("postId") String postId){
        BaseResponse<Post> baseResponse=new BaseResponse<>();
        try {
            baseResponse.setData(postService.getPost(postId));
            baseResponse.setStatus(true);
        }catch (Exception e){
            baseResponse.setErrorMessage(e.getMessage());
            baseResponse.setStatus(false);
        }
        return baseResponse;
    }


    @GetMapping("/newsfeed")
    BaseResponse<List<PostDto>> getNewsFeed(List<String> userIds,int pageNo,int pageSize){
        BaseResponse<List<PostDto>> baseResponse=new BaseResponse<>();
        try {
            List<Post> posts=postService.getNewsFeed(userIds,pageNo,pageSize);
            List<PostDto> postDtos=new ArrayList<>();
            BeanUtils.copyProperties(posts,postDtos);
<<<<<<< HEAD
        //    baseResponse.setData(commentController.getComment(postDtos));
=======
            commentController.getCommentsOfPost(postDtos);
            baseResponse.setData(postDtos);
>>>>>>> ef1a94f868dd35830c908669d8cd8c2ae13cb16f
            baseResponse.setStatus(true);
        }catch (Exception e){
            baseResponse.setStatus(false);
            baseResponse.setErrorMessage(e.getMessage());
        }
        return baseResponse;
    }
}
