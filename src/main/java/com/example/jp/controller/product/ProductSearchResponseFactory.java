package com.example.jp.controller.product;

import com.example.jp.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductSearchResponseFactory {

    public ProductSearchResponse createProductSearchResponse(List<Product> products) {

        List<ProductSearchResponse.ProductInfo> productInfos =
                products.stream().map(this::createProductInfo).collect(Collectors.toList());
        return new ProductSearchResponse(productInfos);
    }

    private ProductSearchResponse.ProductInfo createProductInfo(Product product) {
        return new ProductSearchResponse.ProductInfo(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getPrice(),
                product.getColor(),
                product.isSecondHand(),
                product.getYear(),
                product.getRegistryDate()
        );
    }
}
