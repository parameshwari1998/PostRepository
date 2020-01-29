package com.project.postMicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class CommentDto {

    private String commentId;
    private String commentDescription;
    private String postId;
    private String userId;
    private String commentingUserId;
    private String parentCommentId;
}
