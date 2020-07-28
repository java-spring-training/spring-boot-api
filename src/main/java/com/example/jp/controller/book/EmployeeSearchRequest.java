package com.example.jp.controller.book;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class EmployeeSearchRequest {

    //@NotNull(message = "fullName must not be null")
    @NotNull
    private String fullName;
    //@NotBlank
    private String accName;
    //@Length(max = 10)
    private String address;
    //@Pattern(regexp="(^$|[0-9]{10})")
    private String phone;
}
