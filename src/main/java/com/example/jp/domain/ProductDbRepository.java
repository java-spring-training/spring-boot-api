package com.example.jp.domain;

import java.util.List;

public interface ProductDbRepository {

    String getFirstProductName();
    List<Product> getListAll();
    List<Product> searchByName(String name);
    void addProduct(Product product);
    void addProducts(List<Product> products);
    void updateProduct(Product product);
    void deleteProducts(List<Integer> ids);
}
