package com.example.jp.controller.product;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ProductsDeleteRequest {

    @Size(min = 1, max = 10, message = "Size of list id must be between 1 and 10")
    private List<@Min(value = 1, message = "id must be greater than 0") Integer> ids;
}
