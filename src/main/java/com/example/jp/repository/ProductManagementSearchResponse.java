package com.example.jp.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductManagementSearchResponse {

    private List<ProductManagementInfo> results;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class ProductManagementInfo {
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
