package com.blog.exception;


import java.util.logging.Level;
import java.util.logging.Logger;

public class FindByEmailServiceException extends BlogCustomException{
    private Logger logger = Logger.getLogger("log4j.properties");

    public FindByEmailServiceException(String message, Level level){
        super(message,level);
        logger.log(level,message);
    }
}
