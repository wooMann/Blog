package com.blog.exception;

import org.apache.log4j.Logger;

public class LoginServiceException extends RuntimeException{
    private Logger logger = Logger.getLogger("log4j.properties");

    public LoginServiceException(String message){
        super(message);
        logger.info(message);
    }
}
