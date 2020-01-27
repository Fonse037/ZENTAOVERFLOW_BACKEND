package com.zentaoverflow.springboot.app.post.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zentaoverflow.springboot.app.post.models.PostModel;

@Repository
public interface PostRepository extends CrudRepository<PostModel, Long> {

}
