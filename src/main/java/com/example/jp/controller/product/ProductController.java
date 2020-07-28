package com.example.jp.controller.product;

import com.example.jp.config.DetailApiConfig;
import com.example.jp.config.ListApiConfig;
import com.example.jp.config.ProductConfig;
import com.example.jp.config.StudentConfig;
import com.example.jp.domain.Product;
import com.example.jp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductService service;
    private ListApiConfig listApiConfig;
    private DetailApiConfig detailApiConfig;
    private ProductConfig productConfig;
    private StudentConfig studentConfig;

    @Autowired
    public ProductController(final ProductService service,
                             final ListApiConfig listApiConfig,
                             final DetailApiConfig detailApiConfig,
                             final ProductConfig productConfig,
                             final StudentConfig studentConfig) {
        this.service = service;
        this.listApiConfig = listApiConfig;
        this.detailApiConfig = detailApiConfig;
        this.productConfig = productConfig;
        this.studentConfig = studentConfig;
    }

    @GetMapping("/findAll")
    public List<Product> hello() {
        return service.findAll();
    }
}
