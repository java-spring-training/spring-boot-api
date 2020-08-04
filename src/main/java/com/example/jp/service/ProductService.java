package com.example.jp.service;

import com.example.jp.domain.Product;
import com.example.jp.domain.ProductDbRepository;
import com.example.jp.domain.ProductRepository;
import com.example.jp.exception.DataNotFoundException;
import com.example.jp.exception.ProductSearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;
    private ProductDbRepository dbRepository;

    @Autowired
    public ProductService(final ProductRepository repository, final ProductDbRepository dbRepository) {
        this.repository = repository;
        this.dbRepository = dbRepository;
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

    public void updateProduct(final Product productRequest) throws Exception {

        repository.updateProduct(productRequest);
    }

    public void deleteProduct(final int id) throws Exception {

        repository.deleteProduct(id);
    }

    public String getFirstProductName() {

        return dbRepository.getFirstProductName();
    }

    public List<Product> getListAll() {
        return dbRepository.getListAll();
    }

    public List<Product> searchByName(String name) {
        return dbRepository.searchByName(name);
    }
}
