package com.zentaoverflow.springboot.app.post.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptionPost extends Exception{

	private static final long serialVersionUID = 1770298004513206267L;

	public ResourceNotFoundExceptionPost(String message){
        super(message);
    }

}
