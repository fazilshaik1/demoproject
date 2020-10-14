package com.dxctraining.demoproject.exceptions;

public class InvalidArgumentException extends RuntimeException{
    public InvalidArgumentException(String msg){
        super(msg);
    }
}
