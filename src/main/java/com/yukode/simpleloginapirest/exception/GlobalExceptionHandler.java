package com.yukode.simpleloginapirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException ex){
        ErrorResponse errorResponse = new ErrorResponse("User already Exists", ex.getMessage());
        
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCredentialsxception(InvalidCredentialsException ex){
        ErrorResponse errorResponse = new ErrorResponse("Invalid Crendentials", ex.getMessage());
        
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
}
