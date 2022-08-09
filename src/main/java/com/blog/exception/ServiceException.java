package com.blog.exception;

import java.util.logging.Level;

public class ServiceException extends BlogCustomException{
    public ServiceException(String message, Level level) {
        super(message, level);
    }
}
