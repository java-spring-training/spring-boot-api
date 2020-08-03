package com.example.jp.domain;

import com.example.jp.exception.ProductAddException;
import com.example.jp.exception.ProductDeleteException;
import com.example.jp.exception.ProductSearchException;
import com.example.jp.exception.ProductUpdateException;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll(final Product productRequest) throws ProductSearchException;
    void addProduct(final Product productRequest) throws ProductAddException;
    void updateProduct(final Product productRequest) throws ProductUpdateException;
    void deleteProduct(final int id) throws ProductDeleteException;
}
