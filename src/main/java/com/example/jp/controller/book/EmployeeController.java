package com.example.jp.controller.book;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @GetMapping("/search")
    public String add(@Valid @ModelAttribute final EmployeeSearchRequest employeeSearchRequest,
                      final BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return getErrorMessage(bindingResult);
        }
        return "Success";
    }

    private String getErrorMessage(final BindingResult bindingResult) {

        List<String> errMessages = new ArrayList<>();
        bindingResult.getFieldErrors().forEach(f -> errMessages.add(f.getField() + " " + f.getDefaultMessage()));
        return String.join("\r\n", errMessages);
    }
}
