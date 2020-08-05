package com.example.jp.controller;

import com.example.jp.controller.ErrorResponse.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiEntryPointAccessHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleHttpRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException ex) {

        return new ErrorResponse(new Error(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }
}
