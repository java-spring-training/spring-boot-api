package com.example.jp.repository;

import com.example.jp.domain.Product;
import com.example.jp.domain.ProductRepository;
import com.example.jp.exception.ProductAddException;
import com.example.jp.exception.ProductDeleteException;
import com.example.jp.exception.ProductSearchException;
import com.example.jp.exception.ProductUpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private RestTemplate restTemplate;
    private ProductManagementSearchResponseFactory factory;

    @Autowired
    public ProductRepositoryImpl(@Qualifier("productRestTemplate") final RestTemplate restTemplate,
                                 final ProductManagementSearchResponseFactory factory) {
        this.restTemplate = restTemplate;
        this.factory = factory;
    }

    @Override
    public List<Product> findAll(final Product productRequest) throws ProductSearchException {

        String url = "https://vnexpress.net/";

        ResponseEntity<String> response;
        try {
            response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        } catch (RestClientException ex) {
            throw new ProductSearchException("API Product Management Search has exception");
        }
        // Check http status
        if (ObjectUtils.isEmpty(response)
                || response.getStatusCode() != HttpStatus.OK
                || ObjectUtils.isEmpty(response.getBody())) {
            throw new  ProductSearchException("API Product Management Search has exception");
        }

        return null;
    }

    /*@Override
    public List<Product> findAll(final Product productRequest) {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
        uriBuilder.scheme("http");
        uriBuilder.host("localhost");
        uriBuilder.port(8081);
        uriBuilder.path("product/search");
        uriBuilder.queryParam("name", "car");
        uriBuilder.queryParam("price", 100);

        URI uri = uriBuilder.build().toUri();

        ProductManagementSearchResponse result = restTemplate.getForObject(uri, ProductManagementSearchResponse.class);

        // Factory List<ProductManagementInfo> -> List<Product>
        return factory.createProducts(result);
    }*/

    /*@Override
    public List<Product> findAll(final Product productRequest) throws ProductSearchException {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
        uriBuilder.scheme("http");
        uriBuilder.host("localhost");
        uriBuilder.port(8081);
        uriBuilder.path("product/search");
        uriBuilder.queryParam("name", "car");
        uriBuilder.queryParam("price", 10);
        URI uri = uriBuilder.build().toUri();

        ResponseEntity<ProductManagementSearchResponse> response;
        try {
            response = restTemplate.exchange(uri, HttpMethod.GET, null, ProductManagementSearchResponse.class);
        } catch (RestClientException ex) {
            throw new ProductSearchException("API Product Management Search has exception");
        }
        // Check http status
        if (ObjectUtils.isEmpty(response)
                || response.getStatusCode() != HttpStatus.OK
                || ObjectUtils.isEmpty(response.getBody())) {
            throw new  ProductSearchException("API Product Management Search has exception");
        }

        // Factory List<ProductManagementInfo> -> List<Product>
        return factory.createProducts(response.getBody());
    }*/

    /*@Override
    public void addProduct(Product productRequest) throws ProductAddException {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
        uriBuilder.scheme("http");
        uriBuilder.host("localhost");
        uriBuilder.port(8081);
        uriBuilder.path("product/add");
        URI uri = uriBuilder.build().toUri();

        ProductManagementAddRequest request = new ProductManagementAddRequest("Car", 100);

        HttpEntity<ProductManagementAddRequest> httpEntity = new HttpEntity<>(request, null);

        ProductManagementSuccessResponse response;
        try {
            response = restTemplate.postForObject(uri, httpEntity, ProductManagementSuccessResponse.class);
        } catch (RestClientException ex) {
            throw new ProductAddException("API Product Management Add has exception");
        }

        // do something: Check Response object ProductManagementSuccessResponse ...
        if(ObjectUtils.isEmpty(response) || response.getCode() != HttpStatus.OK.value()) {
            throw new  ProductAddException("API Product Management Add has exception");
        }
    }*/

    @Override
    public void addProduct(Product productRequest) throws ProductAddException {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
        uriBuilder.scheme("http");
        uriBuilder.host("localhost");
        uriBuilder.port(8081);
        uriBuilder.path("product/add");
        URI uri = uriBuilder.build().toUri();

        ProductManagementAddRequest request = new ProductManagementAddRequest("Car", 100);

        HttpEntity<ProductManagementAddRequest> httpEntity = new HttpEntity<>(request, null);

        ResponseEntity<ProductManagementSuccessResponse> response;
        try {
            response = restTemplate.postForEntity(uri, httpEntity, ProductManagementSuccessResponse.class);
        } catch (RestClientException ex) {
            throw new ProductAddException("API Product Management Add has exception");
        }

        // Check http status & Object Response
        if (ObjectUtils.isEmpty(response)
                || response.getStatusCode() != HttpStatus.OK
                || ObjectUtils.isEmpty(response.getBody())
                || response.getBody().getCode() != HttpStatus.OK.value()) {
            throw new  ProductAddException("API Product Management Add has exception");
        }
    }

    /*@Override
    public void updateProduct(Product productRequest) throws ProductUpdateException {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
        uriBuilder.scheme("http");
        uriBuilder.host("localhost");
        uriBuilder.port(8081);
        uriBuilder.path("product/update");
        URI uri = uriBuilder.build().toUri();

        ProductManagementUpdateRequest request =
                new ProductManagementUpdateRequest(productRequest.getName(), productRequest.getPrice());
        HttpEntity<ProductManagementUpdateRequest> httpEntity = new HttpEntity<>(request, null);

        try {
            restTemplate.put(uri, httpEntity);
        } catch (RestClientException ex) {
            throw new ProductUpdateException("API Product Management Update has exception");
        }
    }*/

    @Override
    public void updateProduct(Product productRequest) throws ProductUpdateException {

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
        uriBuilder.scheme("http");
        uriBuilder.host("localhost");
        uriBuilder.port(8081);
        uriBuilder.path("product/update");
        URI uri = uriBuilder.build().toUri();

        ProductManagementUpdateRequest request =
                new ProductManagementUpdateRequest(productRequest.getName(), productRequest.getPrice());
        HttpEntity<ProductManagementUpdateRequest> httpEntity = new HttpEntity<>(request, null);

        ResponseEntity<ProductManagementSuccessResponse> response;
        try {
            response = restTemplate.exchange(uri, HttpMethod.PUT, httpEntity, ProductManagementSuccessResponse.class);
        } catch (RestClientException ex) {
            throw new ProductUpdateException("API Product Management Update has exception");
        }
        // Check http status & Object Response
        if (ObjectUtils.isEmpty(response)
                || response.getStatusCode() != HttpStatus.OK
                || ObjectUtils.isEmpty(response.getBody())
                || response.getBody().getCode() != HttpStatus.OK.value()) {
            throw new  ProductUpdateException("API Product Management Update has exception");
        }
    }

    /*@Override
    public void deleteProduct(int id) throws ProductDeleteException {

        // URI parameters (path variable)
        Map<String, Integer> urlParams = new HashMap<>();
        urlParams.put("id", id);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
        uriBuilder.scheme("http");
        uriBuilder.host("localhost");
        uriBuilder.port(8081);
        uriBuilder.path("product/delete/{id}");
        URI uri = uriBuilder.buildAndExpand(urlParams).toUri();

        try {
            restTemplate.delete(uri);
        } catch (RestClientException ex) {
            throw new ProductDeleteException("API Product Management Delete has exception");
        }
    }*/

    @Override
    public void deleteProduct(int id) throws ProductDeleteException {

        // URI parameters (path variable)
        Map<String, Integer> urlParams = new HashMap<>();
        urlParams.put("id", id);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
        uriBuilder.scheme("http");
        uriBuilder.host("localhost");
        uriBuilder.port(8081);
        uriBuilder.path("product/delete/{id}");
        URI uri = uriBuilder.buildAndExpand(urlParams).toUri();

        ResponseEntity<ProductManagementSuccessResponse> response;
        try {
            response = restTemplate.exchange(uri, HttpMethod.DELETE, null, ProductManagementSuccessResponse.class);
        } catch (RestClientException ex) {
            throw new ProductDeleteException("API Product Management Delete has exception");
        }
        // Check http status & Object Response
        if (ObjectUtils.isEmpty(response)
                || response.getStatusCode() != HttpStatus.OK
                || ObjectUtils.isEmpty(response.getBody())
                || response.getBody().getCode() != HttpStatus.OK.value()) {
            throw new  ProductDeleteException("API Product Management Delete has exception");
        }
    }
}