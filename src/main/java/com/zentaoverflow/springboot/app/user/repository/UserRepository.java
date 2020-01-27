package com.zentaoverflow.springboot.app.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zentaoverflow.springboot.app.user.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long>  {

}


