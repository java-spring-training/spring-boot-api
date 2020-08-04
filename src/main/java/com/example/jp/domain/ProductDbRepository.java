package com.example.jp.domain;

import java.util.List;

public interface ProductDbRepository {

    String getFirstProductName();
    List<Product> getListAll();
    List<Product> searchByName(String name);
}
