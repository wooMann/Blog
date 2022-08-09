package com.blog.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BlogCustomException extends RuntimeException{
    private Logger logger = Logger.getLogger("log4j.properties");
    public BlogCustomException(String message,LogType logType) {
        super(message);
        switch (logType){
            case ERROR: logger.log(Level.SEVERE,message);
                break;
            case WARNING: logger.log(Level.WARNING,message);
                break;
            case INFO: logger.log(Level.INFO,message);
                break;
            case DEBUG: logger.log(Level.CONFIG,message);
                break;
            case TRACE: logger.log(Level.FINE,message);
                break;
        }
    }





}
