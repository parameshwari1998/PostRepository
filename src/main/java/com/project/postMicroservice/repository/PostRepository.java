package com.project.postMicroservice.repository;

import com.project.postMicroservice.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends CrudRepository<Post,String> {
}
