package com.blog.exception;


import java.util.logging.Logger;

public class LoginServiceException extends BlogCustomException{

    public LoginServiceException(String message){
        super(message,LogType.ERROR);
    }
}
