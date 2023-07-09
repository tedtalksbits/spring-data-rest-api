package com.tedaneblake.ankirestapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RequiredFieldMissingAdvice {

    @ResponseBody
    @ExceptionHandler(RequiredFieldMissingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String requiredFieldMissingHandler(RequiredFieldMissingException ex){
        return ex.getMessage();
    }
}
