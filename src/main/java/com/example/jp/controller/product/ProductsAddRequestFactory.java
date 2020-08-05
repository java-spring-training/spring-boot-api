package com.example.jp.controller.product;

import com.example.jp.controller.product.ProductsAddRequest.ProductInfo;
import com.example.jp.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductsAddRequestFactory {

    public List<Product> createProducts(List<ProductInfo> productInfos) {

        return productInfos.stream().map(this::createProduct).collect(Collectors.toList());
    }

    private Product createProduct(ProductInfo productInfo) {
        return new Product(
                productInfo.getName(),
                productInfo.getCategory(),
                productInfo.getPrice(),
                productInfo.getColor(),
                productInfo.isSecondHand(),
                productInfo.getYear(),
                productInfo.getRegistryDate()
        );
    }
}
