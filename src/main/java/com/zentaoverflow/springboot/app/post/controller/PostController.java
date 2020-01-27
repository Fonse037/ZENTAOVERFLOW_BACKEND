package com.zentaoverflow.springboot.app.post.controller;

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

import com.zentaoverflow.springboot.app.post.models.PostModel;
import com.zentaoverflow.springboot.app.post.repository.PostRepository;
import com.zentaoverflow.springboot.app.user.exception.ResourceNotFoundException;






@RestController
@RequestMapping("/api/v1")
public class PostController {
	
    @Autowired
    private PostRepository postRepository;
    
    @GetMapping("/posts")
    public List<PostModel> getAllPost() {
        return (List<PostModel>)postRepository.findAll();
    }
    
    @GetMapping("/post/{id}")
    public ResponseEntity<PostModel> getPostById(@PathVariable(value = "id") Long id_post)
        throws ResourceNotFoundException {
    	PostModel post = postRepository.findById(id_post)
          .orElseThrow(() -> new ResourceNotFoundException("Post not found for this id : " + id_post));
        return ResponseEntity.ok().body(post);
    }
    
    @PostMapping("/post")
    public PostModel createPost(@Valid @RequestBody PostModel post) {
        return postRepository.save(post);
    }
    
    @PutMapping("/post/{id}")
    public ResponseEntity<PostModel> updateUser(@PathVariable(value = "id") Long id_post,
         @Valid @RequestBody PostModel postDetails) throws ResourceNotFoundException {
    	PostModel post = postRepository.findById(id_post)
        .orElseThrow(() -> new ResourceNotFoundException("Post not found for this id : " + id_post));

    	post.setPosttitle(postDetails.getPosttitle());
    	post.setPostcontent(postDetails.getPostcontent());
        final PostModel updatedPost = postRepository.save(post);
        return ResponseEntity.ok(updatedPost);
    }
    
    @DeleteMapping("/post/{id}")
    public Map<String, Boolean> deletePost(@PathVariable(value = "id") Long id_post)
         throws ResourceNotFoundException {
    	PostModel post = postRepository.findById(id_post)
       .orElseThrow(() -> new ResourceNotFoundException("Post not found for this id : " + id_post));

    	postRepository.delete(post);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
