package com.example.jp.repository;

import com.example.jp.domain.Product;
import com.example.jp.repository.ProductManagementSearchResponse.ProductManagementInfo;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductManagementSearchResponseFactory {

    public List<Product> createProducts(ProductManagementSearchResponse response) {

        if(ObjectUtils.isEmpty(response) || CollectionUtils.isEmpty(response.getResults())) {
            return Collections.emptyList();
        }
        return response.getResults().stream().map(this::createProduct).collect(Collectors.toList());
    }

    private Product createProduct(ProductManagementInfo productInfo) {
        return new Product(
                productInfo.getId(),
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
