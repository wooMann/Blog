package com.blog.exception;


import java.util.logging.Logger;

public class FindByEmailServiceException extends RuntimeException{
    private Logger logger = Logger.getLogger("log4j.properties");

    public FindByEmailServiceException(String message){
        super(message);
        logger.info(message);
    }
}
