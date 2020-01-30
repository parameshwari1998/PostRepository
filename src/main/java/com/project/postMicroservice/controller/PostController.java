package com.project.postMicroservice.controller;


import com.project.postMicroservice.dto.BaseResponse;
import com.project.postMicroservice.dto.PostDto;
import com.project.postMicroservice.entity.Post;
import com.project.postMicroservice.service.PostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    CommentController commentController;

    @PostMapping("/create")
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


    @GetMapping("/newsfeed/{userId}/{pageNo}/{pageSize}")
    BaseResponse<List<PostDto>> getNewsFeed(@PathVariable("userId") String userId,@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize){
        List<String> userIds=new ArrayList<>();

        final String url="http://10.177.68.8:8082/friends/getList/"+userId;
        RestTemplate restTemplate=new RestTemplate();
        userIds=restTemplate.getForObject(url,List.class);

        BaseResponse<List<PostDto>> baseResponse=new BaseResponse<>();
        try {
            baseResponse.setData(commentController.getCommentsOfPost(postService.getFeed(userIds,pageNo,pageSize)));
            baseResponse.setStatus(true);
        }catch (Exception e){
            baseResponse.setStatus(false);
            baseResponse.setErrorMessage(e.getMessage());
        }
        return baseResponse;
    }


    @GetMapping("/getUserPost/{userId}/{pageNo}/{pageSize}")
    BaseResponse<List<PostDto>> getUserPost(@PathVariable("userId") String userId,@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize){
        BaseResponse<List<PostDto>> baseResponse=new BaseResponse<>();
        List<String> userIds=new ArrayList<>();
        userIds.add(userId);
        try {
            baseResponse.setData(commentController.getCommentsOfPost(postService.getFeed(userIds,pageNo,pageSize)));
            baseResponse.setStatus(true);
        }catch (Exception e){
            baseResponse.setErrorMessage(e.getMessage());
            baseResponse.setStatus(false);
        }
        return baseResponse;
    }



    @GetMapping("/getPost/{postId}")
    BaseResponse<PostDto> getPost(@PathVariable("postId") String postId){
        BaseResponse<PostDto> baseResponse=new BaseResponse<>();
        try {
            PostDto postDto=new PostDto();
            BeanUtils.copyProperties(postService.getPost(postId),postDto);
            postDto.setComments(commentController.getComment(postId).getData());
            baseResponse.setData(postDto);
            baseResponse.setStatus(true);
        }catch (Exception e){
            baseResponse.setErrorMessage(e.getMessage());
            baseResponse.setStatus(false);
        }
        return baseResponse;
    }


}
