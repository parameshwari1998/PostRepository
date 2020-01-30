package com.project.postMicroservice.service;

import com.project.postMicroservice.dto.PostDto;
import com.project.postMicroservice.entity.Post;

import java.util.List;

public interface PostService {

    Post createPost(Post post);
    List<Post> getPostOfUser(String userId);
    Post getPost(String postId);
    List<PostDto> getFeed(List<String> userId, int pageNo, int pageSize);
    void increaseLike(String postId);
    void decreaseLike(String postId);
    void increaseDislike(String postId);
    void decreaseDislike(String postId);
    void increaseEmojiCounter(String postId);

}
