package com.project.postMicroservice.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = Post.POST_TABLE_NAME)
public class Post {

    public static final String POST_TABLE_NAME="POST";


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
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

    public Post(){
        postDate=new Date();
        counterOfComments=0;
        counterOfLikes=0;
        counterOfDislilkes=0;
        counterOfEmojis=0;
    }

}
