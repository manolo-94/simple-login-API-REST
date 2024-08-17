package com.yukode.simpleloginapirest.exception;

public class UserAlreadyExistsException extends RuntimeException {
    
    public UserAlreadyExistsException(String message){
        super(message);
    }
    
}
