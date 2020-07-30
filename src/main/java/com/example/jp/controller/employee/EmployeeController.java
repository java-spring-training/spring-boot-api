package com.example.jp.controller.employee;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping("/search")
    public String search(@Valid final EmployeeSearchRequest request, final BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return getErrorMessage(bindingResult);
        }
        return "Success";
    }

    @GetMapping("/searchCustomer")
    public String searchCustomer(@Valid final CustomerSearchRequest request, final BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return getErrorMessage(bindingResult);
        }
        return "Success";
    }

    @PostMapping("/searchName")
    public String searchName(@Valid @RequestBody final EmployeeNamesRequest requests, final BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return getErrorMessage(bindingResult);
        }
        return "Success ";
    }

    /*private String getErrorMessage(final BindingResult bindingResult) {

        List<String> errMessages = new ArrayList<>();
        bindingResult.getFieldErrors().forEach(f -> errMessages.add(f.getDefaultMessage()));
        return String.join("\r\n", errMessages);
    }

    private String getMessage(final FieldError error) {
        return !error.isBindingFailure() ? error.getDefaultMessage() : error.getField() + " " + "must be number";
    }*/

    private String getErrorMessage(final BindingResult bindingResult) {

        List<String> errMessages = new ArrayList<>();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(error -> errMessages.add(getMessage(error)));
        return String.join("\r\n", errMessages);
    }

    private HashMap<String, String> errFieldMap = new HashMap<String, String>(){{
        put("age", "age must be number");
        put("cusType", "cusType must be number");
        put("point", "point must be number");
        put("gender", "gender must be 'true' or 'false'");
    }};

    private String getMessage(final FieldError error) {
        return !error.isBindingFailure() ? error.getDefaultMessage() : errFieldMap.get(error.getField());
    }

}
