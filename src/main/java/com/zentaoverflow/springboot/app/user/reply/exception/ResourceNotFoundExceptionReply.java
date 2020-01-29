package com.zentaoverflow.springboot.app.user.reply.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptionReply extends Exception {

	private static final long serialVersionUID = 8621942956353402522L;
	
	public ResourceNotFoundExceptionReply(String message){
        super(message);
    }

}
