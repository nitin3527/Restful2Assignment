package com.restfulServices.restfulServicePart1.exception;

import java.util.Date;

public class ExceptionResponse {
    private Date timeStamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timeStamp, String message, String details){
        this.details = details;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

}
