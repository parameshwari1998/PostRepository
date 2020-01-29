package com.project.postMicroservice.service.impl;

import com.project.postMicroservice.entity.Post;
import com.project.postMicroservice.repository.PostRepository;
import com.project.postMicroservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Post createPost(Post post){
        return postRepository.save(post);
    }

    @Override
    public List<Post> getPostOfUser(String userId){
        return postRepository.findByUserId(userId);
    }

    @Override
    public  Post getPost(String postId){
        return postRepository.findById(postId).get();
    }

    @Override
    public List<Post> getNewsFeed(List<String> userId,int pageNo,int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo,pageSize);
        return postRepository.findByUserIdInOrderByPostDate(userId,pageRequest);
    }


}
