package com.example.jp.service;

import com.example.jp.domain.Product;
import com.example.jp.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductService(final ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll(final Product productRequest) {

        return repository.findAll(productRequest);
    }

    public void addProduct(final Product productRequest) {


        repository.addProduct(productRequest);
    }
}
