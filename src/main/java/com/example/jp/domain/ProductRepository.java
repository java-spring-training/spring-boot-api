package com.example.jp.domain;

import com.example.jp.exception.ProductSearchException;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll(final Product productRequest) throws ProductSearchException;
    void addProduct(final Product productRequest) throws ProductSearchException;
}
