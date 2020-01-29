package com.project.postMicroservice.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = ReactionOnPost.LIKE_ON_POST_TABLE_NAME)
public class ReactionOnPost {

    public static final String LIKE_ON_POST_TABLE_NAME="LIKE_ON_POST";


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String reactedId;
    private String postId ;
    private String likedId;
    private String likeDate;

}
