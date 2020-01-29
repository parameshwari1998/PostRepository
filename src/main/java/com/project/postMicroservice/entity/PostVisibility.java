package com.project.postMicroservice.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = PostVisibility.POST_VISIBILITY_TABLE_NAME)
public class PostVisibility {

    public static final String POST_VISIBILITY_TABLE_NAME="POST_VISIBILITY";


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String postVisibilityId;
    private String postId;
    private String reactedTo;

}
