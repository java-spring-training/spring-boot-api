package com.example.jp.controller.product;

import com.example.jp.domain.Product;
import com.example.jp.controller.product.ProductSearchResponse.ProductInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductSearchResponseFactory {

    public ProductSearchResponse createProductSearchResponse(List<Product> products) {

        List<ProductInfo> productInfos = products.stream().map(this::createProductInfo).collect(Collectors.toList());
        return new ProductSearchResponse(productInfos);
    }

    private ProductInfo createProductInfo(Product product) {
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
