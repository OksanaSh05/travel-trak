package com.dyplom.travel.exceptions;

public class NotAuthenticatedException extends RuntimeException{

    public NotAuthenticatedException(String msg) {
        super(msg);
    }
}
