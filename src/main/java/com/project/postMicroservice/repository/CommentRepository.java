package com.project.postMicroservice.repository;

import com.project.postMicroservice.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends CrudRepository<Comment,String> {

    List<Comment> findByPostId(String postId);

}
