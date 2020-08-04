package com.example.jp.repository;

import com.example.jp.domain.Product;
import com.example.jp.domain.ProductDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;

@Repository
public class ProductDbRepositoryImpl implements ProductDbRepository {

    private ProductMapper mapper;

    @Autowired
    public ProductDbRepositoryImpl(final ProductMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String getFirstProductName() {
        return mapper.getFirstProductName();
    }

    @Override
    public List<Product> getListAll() {
        return mapper.getListAll();
    }

    @Override
    public List<Product> searchByName(String name) {
        return mapper.searchByName("%" + name + "%");
        //return mapper.searchByName(name);
    }
}