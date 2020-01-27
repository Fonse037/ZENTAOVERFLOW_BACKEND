package com.zentaoverflow.springboot.app.post.exception;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.zentaoverflow.springboot.app.post.exception.ErrorDetailsPost;
import com.zentaoverflow.springboot.app.post.exception.ResourceNotFoundExceptionPost;

@ControllerAdvice
public class GlobalExceptionHandlerPost {

    @ExceptionHandler(ResourceNotFoundExceptionPost.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundExceptionPost ex, WebRequest request) {
         ErrorDetailsPost errorDetails = new ErrorDetailsPost(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        ErrorDetailsPost errorDetails = new ErrorDetailsPost(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
