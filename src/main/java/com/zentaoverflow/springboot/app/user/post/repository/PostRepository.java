package com.zentaoverflow.springboot.app.user.post.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zentaoverflow.springboot.app.user.post.models.PostModel;

@Repository
public interface PostRepository extends CrudRepository<PostModel, Long> {

}
