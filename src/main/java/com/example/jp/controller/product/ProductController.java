package com.example.jp.controller.product;

import com.example.jp.config.DetailApiConfig;
import com.example.jp.config.ListApiConfig;
import com.example.jp.config.ProductConfig;
import com.example.jp.config.StudentConfig;
import com.example.jp.controller.SuccessResponse;
import com.example.jp.domain.Product;
import com.example.jp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class ProductController {

    private ProductService service;
    private ListApiConfig listApiConfig;
    private DetailApiConfig detailApiConfig;
    private ProductConfig productConfig;
    private StudentConfig studentConfig;
    private ProductSearchResponseFactory productFactory;
    private ProductsAddRequestFactory productsAddRequestFactory;

    @Autowired
    public ProductController(final ProductService service,
                             final ListApiConfig listApiConfig,
                             final DetailApiConfig detailApiConfig,
                             final ProductConfig productConfig,
                             final StudentConfig studentConfig,
                             final ProductSearchResponseFactory productFactory,
                             final ProductsAddRequestFactory productsAddRequestFactory) {
        this.service = service;
        this.listApiConfig = listApiConfig;
        this.detailApiConfig = detailApiConfig;
        this.productConfig = productConfig;
        this.studentConfig = studentConfig;
        this.productFactory = productFactory;
        this.productsAddRequestFactory = productsAddRequestFactory;
    }

    @GetMapping("/searchProduct")
    public ProductSearchResponse searchProduct(final @Valid ProductSearchRequest request,
                                               final BindingResult bindingResult) throws Exception {

        if(bindingResult.hasErrors()) {
            throw new InvalidParameterException(getErrorMessage(bindingResult));
        }
        // Create Domain Product Request to send to repository
        Product productRequest = new Product(
                request.getName(),
                request.getPrice(),
                request.isSecondHand(),
                request.getRegistryDate()
        );

        List<Product> products = service.findAll(productRequest);
        return productFactory.createProductSearchResponse(products);
    }

    @PostMapping("/addProduct")
    public SuccessResponse addProduct(final @Valid @RequestBody ProductAddRequest request,
                                      final BindingResult bindingResult) throws Exception {

        if(bindingResult.hasErrors()) {
            throw new InvalidParameterException(getErrorMessage(bindingResult));
        }
        // Create Domain Product Request to send to repository
        Product productRequest = new Product(
                request.getName(),
                request.getCategory(),
                request.getPrice(),
                request.getColor(),
                request.isSecondHand(),
                request.getYear(),
                request.getRegistryDate()
        );
        service.addProduct(productRequest);
        return new SuccessResponse(HttpStatus.OK.value(), "SUCCESS");
    }

    @PutMapping("/updateProduct")
    public SuccessResponse updateProduct(final @RequestBody ProductUpdateRequest request) throws Exception {

        // Create Domain Product Request to send to repository
        Product productRequest = new Product(
                request.getName(),
                request.getPrice()
        );
        service.updateProduct(productRequest);
        return new SuccessResponse(HttpStatus.OK.value(), "SUCCESS");
    }

    @DeleteMapping("/deleteProduct/{id}")
    public SuccessResponse deleteProduct(final ProductDeleteRequest request) throws Exception {

        service.deleteProduct(request.getId());
        return new SuccessResponse(HttpStatus.OK.value(), "SUCCESS");
    }

    private String getErrorMessage(final BindingResult bindingResult) {

        List<String> errMessages = new ArrayList<>();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        fieldErrors.forEach(error -> errMessages.add(getMessage(error)));
        return String.join("\r\n", errMessages);
    }

    @GetMapping("/product/test/name")
    public String getFirstProductName() {

        return service.getFirstProductName();
    }

    @GetMapping("/product/listAll")
    public ProductSearchResponse listAll() {

        List<Product> products = service.getListAll();
        return productFactory.createProductSearchResponse(products);
    }

    @GetMapping("/product/searchByName")
    public ProductSearchResponse searchByName(@RequestParam final String name) {

        List<Product> products = service.searchByName(name);
        return productFactory.createProductSearchResponse(products);
    }

    @PostMapping("/product/addProduct")
    public SuccessResponse addUnitProduct(final @Valid @RequestBody ProductAddRequest request,
                                      final BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            throw new InvalidParameterException(getErrorMessage(bindingResult));
        }
        // Create Domain Product Request to send to repository
        Product productRequest = new Product(
                request.getName(),
                request.getCategory(),
                request.getPrice(),
                request.getColor(),
                request.isSecondHand(),
                request.getYear(),
                request.getRegistryDate()
        );
        service.addUnitProduct(productRequest);
        return new SuccessResponse(HttpStatus.OK.value(), "SUCCESS");
    }

    @PostMapping("/product/addProducts")
    public SuccessResponse addProducts(final @Valid @RequestBody ProductsAddRequest request,
                                          final BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            throw new InvalidParameterException(getErrorMessage(bindingResult));
        }
        List<Product> productsRequest = productsAddRequestFactory.createProducts(request.getProducts());
        service.addListProduct(productsRequest);
        return new SuccessResponse(HttpStatus.OK.value(), "SUCCESS");
    }

    @PutMapping("/product/updateProduct")
    public SuccessResponse updateUnitProduct(final @Valid @RequestBody ProductUpdateRequest request,
                                          final BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            throw new InvalidParameterException(getErrorMessage(bindingResult));
        }
        // Create Domain Product Request to send to repository
        Product productRequest = new Product(
                request.getId(),
                request.getName(),
                request.getCategory(),
                request.getPrice(),
                request.getColor()
        );
        service.updateUnitProduct(productRequest);
        return new SuccessResponse(HttpStatus.OK.value(), "SUCCESS");
    }

    @DeleteMapping("/product/deleteProducts")
    public SuccessResponse deleteProducts(@Valid final @RequestBody ProductsDeleteRequest request,
                                          final BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            throw new InvalidParameterException(getErrorMessage(bindingResult));
        }

        service.deleteListProduct(request.getIds());
        return new SuccessResponse(HttpStatus.OK.value(), "SUCCESS");
    }




    private HashMap<String, String> errFieldMap = new HashMap<String, String>(){{
        put("price", "price must be a number");
        put("secondHand", "secondHand must be 'true' or 'false'");
        put("registryDate", "registryDate must be in a date format 'yyyy-MM-dd'");
    }};

    private String getMessage(final FieldError error) {
        return !error.isBindingFailure() ? error.getDefaultMessage() : errFieldMap.get(error.getField());
    }
}
