package com.project.postMicroservice.repository;

import com.project.postMicroservice.entity.ReactionOnPost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReactionOnPostRepository extends CrudRepository<ReactionOnPost,String> {


    ReactionOnPost findByPostIdAndReactedUserId(String postId,String reactedUserId);

    @Query(
            value = "select reacted_user_id from reaction_on_post where post_id=:postId",
            nativeQuery = true
    )
    List<String> findAllreactedUsers(@Param("postId") String postId);

}
