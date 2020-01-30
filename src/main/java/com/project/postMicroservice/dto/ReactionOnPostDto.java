package com.project.postMicroservice.dto;

import lombok.Data;

import java.util.Date;


@Data
public class ReactionOnPostDto {

    private String postId ;
    private String reactedUserId;
    private Date reactedDate;
    private String reactionType;

}
