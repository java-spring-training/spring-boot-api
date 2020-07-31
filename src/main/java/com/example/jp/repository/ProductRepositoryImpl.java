package com.example.jp.repository;

import com.example.jp.domain.Product;
import com.example.jp.domain.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> findAll(final Product productRequest) {

        return new ArrayList<>(Arrays.asList(
                new Product(1, "Toyota Camry", "Car", 1000, "Red", false, 2020, null),
                new Product(2, "BMW X5", "Car", 500, "Green", true, 2019, new Date()),
                new Product(3, "Honda SH", "Motorcycle", 3000, "White", false, 2020, null),
                new Product(4, "Yamaha Exciter", "Motorcycle", 200, "Blue", true, 2015, new Date())));
    }

    @Override
    public void addProduct(Product productRequest) {

        // Insert productRequest into database
        // Throw some exceptions if add fail: Connection Timeout, Database Error
    }
}