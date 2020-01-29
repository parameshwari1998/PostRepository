package com.project.postMicroservice.dto;

import com.project.postMicroservice.entity.Comment;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
public class PostDto {

    private Boolean isBusinessProfilePost;
    private String postDescription;
    private String postImageUrl;
    private String postVideoUrl;
    private String userId;
    private String postDate;
    private Integer counterOfLikes;
    private Integer counterOfDislilkes;
    private Integer counterOfEmojis;
    private Integer counterOfComments;
    private List<Comment> comments;


}
