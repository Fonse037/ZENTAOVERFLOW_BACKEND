package com.zentaoverflow.springboot.app.user.controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zentaoverflow.springboot.app.user.models.UserModel;
import com.zentaoverflow.springboot.app.user.repository.UserRepository;
import com.zentaoverflow.springboot.app.user.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<UserModel> getAllUsers() {
        return (List<UserModel>)userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable(value = "id") Long id_user)
        throws ResourceNotFoundException {
        UserModel user = userRepository.findById(id_user)
          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id : " + id_user));
        return ResponseEntity.ok().body(user);
    }
    
    @PostMapping("/user")
    public UserModel createUser(@Valid @RequestBody UserModel user) {
        return userRepository.save(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable(value = "id") Long id_user,
         @Valid @RequestBody UserModel userDetails) throws ResourceNotFoundException {
    	UserModel user = userRepository.findById(id_user)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id : " + id_user));

        user.setUsername(userDetails.getUsername());
        user.setUsersurname(userDetails.getUsersurname());
        final UserModel updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @PutMapping("/delete/user/{id}")
    public ResponseEntity<UserModel> deleteUser(@PathVariable(value = "id") Long id_user,
            @Valid @RequestBody UserModel userDetails) throws ResourceNotFoundException {
       	UserModel user = userRepository.findById(id_user)
           .orElseThrow(() -> new ResourceNotFoundException("User not found for this id : " + id_user));

        user.setFk_id_status(userDetails.getFk_id_status());
        final UserModel deletedUser = userRepository.save(user);
        return ResponseEntity.ok(deletedUser);
    }
    
    @PutMapping("/pwd/user/{id}")
    public ResponseEntity<UserModel> updatePassUser(@PathVariable(value = "id") Long id_user,
         @Valid @RequestBody UserModel userDetails) throws ResourceNotFoundException {
    	UserModel user = userRepository.findById(id_user)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id : " + id_user));

        user.setUserpwd(userDetails.getUserpwd());
        final UserModel updatedPassUser = userRepository.save(user);
        return ResponseEntity.ok(updatedPassUser);
    }

}






