package com.blog.exception;

import java.util.logging.Level;

public class DAOException extends BlogCustomException{
    public DAOException(String message, Level level) {
        super(message, level);
    }
}
