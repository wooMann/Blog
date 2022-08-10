package com.blog.exception;


import org.apache.log4j.Level;

public class DAOException extends BlogCustomException{
    public DAOException(String message, Level level) {
        super(message, level);
    }
}
