package com.example.jp.controller.product;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class ProductUpdateRequest {

    private int id;
    private String name;
    private String category;
    private int price;
    private String color;
}
