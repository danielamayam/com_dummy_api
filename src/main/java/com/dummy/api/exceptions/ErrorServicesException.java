package com.dummy.api.exceptions;

public class ErrorServicesException extends RuntimeException{
    public ErrorServicesException(String exceptionMessage) {
        super(exceptionMessage);
    }

}
