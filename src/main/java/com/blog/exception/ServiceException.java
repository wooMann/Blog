package com.blog.exception;


import org.apache.log4j.Level;

public class ServiceException extends BlogCustomException{
    public ServiceException(String message, Level level) {
        super(message, level);
    }
}
