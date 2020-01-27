package com.zentaoverflow.springboot.app.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id_user));

        user.setUsermail(userDetails.getUsermail());
        user.setUsername(userDetails.getUsername());
        user.setUsersurname(userDetails.getUsersurname());
        final UserModel updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long id)
         throws ResourceNotFoundException {
    	UserModel user = userRepository.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}






