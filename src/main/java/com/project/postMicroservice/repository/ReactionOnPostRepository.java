package com.project.postMicroservice.repository;

import com.project.postMicroservice.entity.ReactionOnPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReactionOnPostRepository extends CrudRepository<ReactionOnPost,String> {
}
