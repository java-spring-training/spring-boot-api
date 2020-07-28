package com.example.jp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {

    private int id;
    private String name;
    private String category;
}
