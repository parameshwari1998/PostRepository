package com.project.postMicroservice.repository;

import com.project.postMicroservice.entity.Post;
import org.springframework.data.domain.Pageable;
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

    List<Post> findByUserIdInOrderByPostDate(List<String> userIds,Pageable pageable);





}
