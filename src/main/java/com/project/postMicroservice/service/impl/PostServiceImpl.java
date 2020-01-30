package com.project.postMicroservice.service.impl;

import com.project.postMicroservice.dto.PostDto;
import com.project.postMicroservice.entity.Post;
import com.project.postMicroservice.repository.PostRepository;
import com.project.postMicroservice.service.PostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public List<PostDto> getFeed(List<String> userId,int pageNo,int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo,pageSize);
        List<Post> posts= postRepository.findByUserIdIn(userId,pageRequest);
        List<PostDto> postDtos=new ArrayList<>();
        for (Post post:posts) {
            PostDto postDto = new PostDto();
            BeanUtils.copyProperties(post, postDto);
            postDtos.add(postDto);
        }
        return postDtos;
    }


    @Transactional
    @Override
    public void increaseLike(String postId) {
         postRepository.updateCounterOfLikes(1,postId);
    }

    @Transactional
    @Override
    public void decreaseLike(String postId) {
        postRepository.updateCounterOfLikes(-1,postId);
    }

    @Transactional
    @Override
    public void increaseDislike(String postId) {
        postRepository.updateCounterOfDislikes(1,postId);
    }

    @Transactional
    @Override
    public void decreaseDislike(String postId) {
        postRepository.updateCounterOfDislikes(-1,postId);
    }

    @Transactional
    @Override
    public void increaseEmojiCounter(String postId) {
        postRepository.updateCounterOfEmojis(1,postId);
    }
}
