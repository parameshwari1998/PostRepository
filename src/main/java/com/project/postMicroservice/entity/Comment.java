package com.project.postMicroservice.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Comment.COMMENT_TABLE_NAME)
public class Comment {

    public static final String COMMENT_TABLE_NAME = "COMMENT";

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String commentId;
    private String commentDescription;
    private String PostId;
    private String userId;
    private String commentingUserId;
    private String commentDate;
    private String parentCommentId;

}
