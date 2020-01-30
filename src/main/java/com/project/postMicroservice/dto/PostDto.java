package com.project.postMicroservice.dto;

import com.project.postMicroservice.entity.Comment;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PostDto {

    private String postId;
    private Boolean isBusinessProfilePost;
    private String postDescription;
    private String postImageUrl;
    private String postVideoUrl;
    private String userId;
    private Date postDate;
    private Integer counterOfLikes;
    private Integer counterOfDislilkes;
    private Integer counterOfEmojis;
    private Integer counterOfComments;
    private List<Comment> comments;


    public PostDto(){
        postDate=new Date();
        counterOfComments=0;
        counterOfLikes=0;
        counterOfDislilkes=0;
        counterOfEmojis=0;
    }


}
