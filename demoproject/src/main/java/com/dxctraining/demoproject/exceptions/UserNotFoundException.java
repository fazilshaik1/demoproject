package com.dxctraining.demoproject.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String msg){
        super(msg);
    }
}
