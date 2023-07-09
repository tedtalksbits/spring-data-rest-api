package com.tedaneblake.ankirestapi.exceptions;

public class RequiredFieldMissingException extends RuntimeException{

    public RequiredFieldMissingException(String message) {
        super(message);
    }
}
