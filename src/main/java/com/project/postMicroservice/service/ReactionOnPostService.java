package com.project.postMicroservice.service;

import com.project.postMicroservice.entity.ReactionOnPost;

import java.util.List;

public interface ReactionOnPostService {


    ReactionOnPost createReaction(ReactionOnPost reactionOnPost);
    ReactionOnPost getReaction(String postId,String userId);
    List<String> findReactedUsers(String postId);


}
