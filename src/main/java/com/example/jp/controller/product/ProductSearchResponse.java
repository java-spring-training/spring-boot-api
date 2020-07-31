package com.example.jp.controller.product;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
public class ProductSearchResponse {

    private List<ProductInfo> results;

    @AllArgsConstructor
    @Data
    public static class ProductInfo {
        private int id;
        private String name;
        private String category;
        private int price;
        private String color;
        private boolean secondHand;
        private int year;
        private Date registryDate;
    }
}
