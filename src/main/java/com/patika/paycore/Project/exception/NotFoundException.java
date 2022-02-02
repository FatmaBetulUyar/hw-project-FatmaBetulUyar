package com.patika.paycore.Project.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message+" not found!");
    }
}
