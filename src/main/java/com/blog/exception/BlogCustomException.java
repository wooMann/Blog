package com.blog.exception;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class BlogCustomException extends RuntimeException{
    private Logger logger = Logger.getLogger("log4j.properties");
    public BlogCustomException(String message, Level level) {
        super(message);
        logger.log(level,message);
    }
}
