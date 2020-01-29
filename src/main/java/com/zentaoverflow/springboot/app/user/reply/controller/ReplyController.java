package com.zentaoverflow.springboot.app.user.reply.controller;

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


import com.zentaoverflow.springboot.app.user.reply.exception.ResourceNotFoundExceptionReply;
import com.zentaoverflow.springboot.app.user.reply.models.ReplyModel;
import com.zentaoverflow.springboot.app.user.reply.repository.ReplyRepository;



@RestController
@RequestMapping("/api/v1")
public class ReplyController {

	@Autowired
	private ReplyRepository replyRepository;
	
    @GetMapping("/replys")
    public List<ReplyModel> getAllPost() {
        return (List<ReplyModel>)replyRepository.findAll();
    }
    
    @GetMapping("/reply/{id}")
    public ResponseEntity<ReplyModel> getPostById(@PathVariable(value = "id") Long id_reply)
        throws ResourceNotFoundExceptionReply {
    	ReplyModel reply = replyRepository.findById(id_reply)
          .orElseThrow(() -> new ResourceNotFoundExceptionReply("Reply not found for this id : " + id_reply));
        return ResponseEntity.ok().body(reply);
    }
    
    @PostMapping("/reply")
    public ReplyModel createReply(@Valid @RequestBody ReplyModel reply) {
        return replyRepository.save(reply);
    }
    
    @PutMapping("/reply/{id}")
    public ResponseEntity<ReplyModel> updateReply(@PathVariable(value = "id") Long id_reply,
         @Valid @RequestBody ReplyModel replyDetails) throws ResourceNotFoundExceptionReply {
    	ReplyModel reply = replyRepository.findById(id_reply)
        .orElseThrow(() -> new ResourceNotFoundExceptionReply("Reply not found for this id : " + id_reply));

    	reply.setReplycontent(replyDetails.getReplycontent());
        final ReplyModel updatedReply = replyRepository.save(reply);
        return ResponseEntity.ok(updatedReply);
    }
    
    @DeleteMapping("/reply/{id}")
    public Map<String, Boolean> deleteReply(@PathVariable(value = "id") Long id_reply)
         throws ResourceNotFoundExceptionReply {
    	ReplyModel reply = replyRepository.findById(id_reply)
       .orElseThrow(() -> new ResourceNotFoundExceptionReply("Reply not found for this id : " + id_reply));

    	replyRepository.delete(reply);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
