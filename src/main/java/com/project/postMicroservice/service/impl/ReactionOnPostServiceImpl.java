package com.project.postMicroservice.service.impl;

import com.project.postMicroservice.entity.ReactionOnPost;
import com.project.postMicroservice.repository.ReactionOnPostRepository;
import com.project.postMicroservice.service.ReactionOnPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReactionOnPostServiceImpl implements ReactionOnPostService {

    @Autowired
    ReactionOnPostRepository reactionOnPostRepository;

    @Override
    public ReactionOnPost createReaction(ReactionOnPost reactionOnPost) {
        return reactionOnPostRepository.save(reactionOnPost);
    }

    @Override
    public ReactionOnPost getReaction(String postId,String userId) {
        return reactionOnPostRepository.findByPostIdAndReactedUserId(postId,userId);
    }

    @Override
    public List<String> findReactedUsers(String postId) {
        return reactionOnPostRepository.findAllreactedUsers(postId);
    }
}
