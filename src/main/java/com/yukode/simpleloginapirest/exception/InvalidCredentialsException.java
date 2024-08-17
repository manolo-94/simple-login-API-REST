package com.yukode.simpleloginapirest.exception;

public class InvalidCredentialsException extends RuntimeException {
    
    public InvalidCredentialsException(String message){
        super(message);
    }
    
}
