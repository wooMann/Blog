package com.blog.exception;

import org.apache.log4j.Logger;

public class FindByEmailServiceException extends RuntimeException{
    private Logger logger = Logger.getLogger("log4j.properties");

    public FindByEmailServiceException(String message){
        super(message);
        logger.info(message);
    }
}
