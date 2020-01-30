package com.project.postMicroservice.repository;

import com.project.postMicroservice.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends CrudRepository<Post,String>,PagingAndSortingRepository<Post,String> {

    List<Post> findByUserId(String userId);

//    List<Post> findFirst10ByUserIdInOrderByPostDateDesc(List<String> userIds);

    List<Post> findByUserIdIn(List<String> userIds, Pageable pageable);

    @Modifying
    @Query(
            value = "update post set counter_of_likes= + :value  where post_id=:postId",
            nativeQuery = true
    )
    void updateCounterOfLikes(@Param("value") Integer value,@Param("postId") String postId);


    @Modifying
    @Query(
            value = "update post set counter_of_dislikes= + :value  where post_id=:postId",
            nativeQuery = true
    )
    void updateCounterOfDislikes(@Param("value") Integer value,@Param("postId") String postId);


    @Modifying
    @Query(
            value = "update post set counter_of_emojis= + :value  where post_id=:postId",
            nativeQuery = true
    )
    void updateCounterOfEmojis(@Param("value") Integer value,@Param("postId") String postId);


    @Modifying
    @Query(
            value = "update post set counter_of_comments= + :value  where post_id=:postId",
            nativeQuery = true
    )
    void updateCounterOfComments(@Param("value") Integer value,@Param("postId") String postId);



}
