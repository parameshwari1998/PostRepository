package com.project.postMicroservice.dto;


import lombok.Data;


@Data
public class CommentDto {

    private String postId;
    private String userId;
    private String commentDescription;
    private String commentingUserId;
    private String parentCommentId;
}
