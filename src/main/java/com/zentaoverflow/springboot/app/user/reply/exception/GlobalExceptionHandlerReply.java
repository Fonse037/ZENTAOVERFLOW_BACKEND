package com.zentaoverflow.springboot.app.user.reply.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobalExceptionHandlerReply {

    @ExceptionHandler(ResourceNotFoundExceptionReply.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundExceptionReply ex, WebRequest request) {
         ErrorDetailsReply errorDetails = new ErrorDetailsReply(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
    	ErrorDetailsReply errorDetails = new ErrorDetailsReply(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
