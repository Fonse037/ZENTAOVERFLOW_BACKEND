package com.zentaoverflow.springboot.app.user.reply.exception;

import java.util.Date;

public class ErrorDetailsReply {

    private Date timestamp;
    private String message;
    private String details;
    
    public ErrorDetailsReply(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
   }
    
    public Date getTimestamp() {
        return timestamp;
   }

   public String getMessage() {
        return message;
   }

   public String getDetails() {
        return details;
   }
}
