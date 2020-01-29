package com.project.postMicroservice.repository;

import com.project.postMicroservice.entity.PostVisibility;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostVisibilityRepository extends CrudRepository<PostVisibility,String> {
}
