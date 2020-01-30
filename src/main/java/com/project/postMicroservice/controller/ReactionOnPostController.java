package com.project.postMicroservice.controller;



import com.project.postMicroservice.dto.BaseResponse;
import com.project.postMicroservice.dto.ReactionOnPostDto;
import com.project.postMicroservice.entity.ReactionOnPost;
import com.project.postMicroservice.service.PostService;
import com.project.postMicroservice.service.ReactionOnPostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/reaction")
public class ReactionOnPostController {

    @Autowired
    ReactionOnPostService reactionOnPostService;

    @Autowired
    PostService postService;


    @PostMapping("/{userId}")
    BaseResponse<ReactionOnPost> createReaction(@PathVariable("userId") String userId,@RequestBody ReactionOnPostDto reactionOnPostDto){
        reactionOnPostDto.setReactedUserId(userId);
        BaseResponse<ReactionOnPost> baseResponse=new BaseResponse<>();
        ReactionOnPost reactionOnPost=new ReactionOnPost();
        BeanUtils.copyProperties(reactionOnPostDto,reactionOnPost);
        try {
            ReactionOnPost newReaction=reactionOnPostService.createReaction(reactionOnPost);
            baseResponse.setData(newReaction);
            baseResponse.setStatus(true);
            if(newReaction.getReactionType()=="dislike")
                postService.increaseDislike(newReaction.getPostId());
            else if(newReaction.getReactionType() == "like")
                postService.increaseLike(newReaction.getPostId());
            else
                postService.increaseEmojiCounter(newReaction.getPostId());

            List<String> reactedUsers=reactionOnPostService.findReactedUsers(newReaction.getPostId());

            RestTemplate restTemplate=new RestTemplate();
            Set<String> notificationList = new HashSet<>();
            for (String reactedUserId:reactedUsers) {
                final String url="http://10.177.68.8:8082/friends/getList/"+reactedUserId;
                List<String> userIds=restTemplate.getForObject(url,List.class);
                notificationList.addAll(userIds);
            }
        }catch (Exception e){
            baseResponse.setErrorMessage(e.getMessage());
            baseResponse.setStatus(false);
        }
        return baseResponse;
    }

    @GetMapping("/{postId}/{userId}")
    ReactionOnPost getReaction(@PathVariable("postId") String postId,@PathVariable("userId") String userId){
        return reactionOnPostService.getReaction(postId,userId);
    }

}
