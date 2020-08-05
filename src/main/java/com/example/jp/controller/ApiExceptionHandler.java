package com.example.jp.controller;

import com.example.jp.exception.DataNotFoundException;
import com.example.jp.exception.ProductSearchException;
import com.example.jp.controller.ErrorResponse.Error;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.reflection.ReflectionException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.security.InvalidParameterException;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleIllegalArgumentException(final IllegalArgumentException ex) {
        return new ErrorResponse(new Error(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidParameterException(final InvalidParameterException ex) {
        return new ErrorResponse(new Error(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(final ConstraintViolationException ex) {
        return new ErrorResponse(new Error(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handleDataNotFoundException(final DataNotFoundException ex) {
        return new ErrorResponse(new Error(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

    @ExceptionHandler(ProductSearchException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleProductSearchException(final ProductSearchException ex) {
        return new ErrorResponse(new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
    }

    @ExceptionHandler(MyBatisSystemException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleMyBatisSystemException(final MyBatisSystemException ex) {

        String message = ObjectUtils.isEmpty(ex.getCause().getCause())
                ? ex.getCause().getMessage()
                : ex.getCause().getCause().getMessage();
        return new ErrorResponse(new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), message));
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleDataAccessException(final DataAccessException ex) {
        return new ErrorResponse(new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getCause().getMessage()));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(final Exception ex) {
        return new ErrorResponse(new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
    }
}
