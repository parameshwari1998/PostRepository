package com.project.postMicroservice.service;

import com.project.postMicroservice.entity.Post;

import java.util.List;

public interface PostService {

    Post createPost(Post post);
    List<Post> getPostOfUser(String userId);
    Post getPost(String postId);
    List<Post> getNewsFeed(List<String> userId,int pageNo,int pageSize);


}
