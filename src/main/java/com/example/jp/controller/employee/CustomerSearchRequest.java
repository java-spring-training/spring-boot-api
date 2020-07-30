package com.example.jp.controller.employee;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class CustomerSearchRequest {

    @Min(value = 5, message = "age must be greater than or equal to 5")
    private int age;

    @Min(value = 0, message = "cusType must be 0 or 1")
    @Max(value = 1, message = "cusType must be 0 or 1")
    private int cusType; // only: 0 | 1

    @Range(min = 1, max = 10, message = "point must be between 1 and 10")
    private int point; // form 1 -> 10

    private boolean gender; // true | false | 0 | 1
}