package com.blog.exception;


import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginServiceException extends BlogCustomException{


    public LoginServiceException(String message , Level level){
        super(message,level);
    }
}
