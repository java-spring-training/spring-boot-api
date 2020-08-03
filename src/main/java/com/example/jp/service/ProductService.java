package com.example.jp.service;

import com.example.jp.domain.Product;
import com.example.jp.domain.ProductRepository;
import com.example.jp.exception.DataNotFoundException;
import com.example.jp.exception.ProductSearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductService(final ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll(final Product productRequest) throws Exception {

        List<Product> products = repository.findAll(productRequest);
        if(CollectionUtils.isEmpty(products)) {
            throw new DataNotFoundException("Product list is empty");
        }
        return products;
    }

    public void addProduct(final Product productRequest) throws Exception {

        repository.addProduct(productRequest);
    }
}
