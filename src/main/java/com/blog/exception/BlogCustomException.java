package com.blog.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BlogCustomException extends RuntimeException{
    private Logger logger = Logger.getLogger("log4j.properties");

    public BlogCustomException(String message,Level level) {
        super(message);
        logger.log(level,message);
    }

}
