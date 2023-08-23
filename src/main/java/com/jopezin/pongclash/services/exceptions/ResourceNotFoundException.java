package com.jopezin.pongclash.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String msg){
        super("Resource not found, id: " + msg);
    }
}
