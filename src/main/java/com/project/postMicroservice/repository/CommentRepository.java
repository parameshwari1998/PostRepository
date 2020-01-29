package com.project.postMicroservice.repository;

import com.project.postMicroservice.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends CrudRepository<Comment,String> {
}
