package com.example.jp.domain;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll(final Product productRequest);
    void addProduct(final Product productRequest);
}
