package com.example.jp.controller.employee;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class EmployeeNamesRequest {

    //@NotEmpty(message = "List name must not be empty")
    @Size(min = 2, max = 4, message = "Size of list name must be between 2 and 4")
    private List<@NotBlank(message = "name must not be blank") String> names;
}
