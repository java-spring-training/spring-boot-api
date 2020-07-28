package com.example.jp.repository;

import com.example.jp.domain.Product;
import com.example.jp.domain.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(Arrays.asList(
                new Product(1, "Toyota Camry", "Car"),
                new Product(2, "BMW X5", "Car"),
                new Product(3, "Honda SH", "Motorcycle"),
                new Product(4, "Yamaha Exciter", "Motorcycle")));
    }
}
