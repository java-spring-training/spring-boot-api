package com.example.jp.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorPageController implements ErrorController {

    @RequestMapping("/404")
    public ErrorResponse HandlerErrorNotFoundUrl() {

        return new ErrorResponse(new ErrorResponse.Error(HttpStatus.NOT_FOUND.value(), "Page Not Found"));
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
