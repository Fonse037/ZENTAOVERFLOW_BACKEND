package com.zentaoverflow.springboot.app.user.reply.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zentaoverflow.springboot.app.user.reply.models.ReplyModel;

@Repository
public interface ReplyRepository extends CrudRepository<ReplyModel, Long> {

}
