package com.example.jp.domain;

import com.google.common.base.Preconditions;
import lombok.Data;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Date;

@Data
public class Product {

    private int id;
    private String name;
    private String category;
    private int price;
    private String color;
    private boolean secondHand;
    private int year;
    private Date registryDate;

    public Product(int id, String name, String category, int price, String color, boolean secondHand, int year, Date registryDate) {

        // Validate output base on Database constrain. Ex: check require not null
        Preconditions.checkArgument(!StringUtils.isEmpty(name), "name must not be empty");
        Preconditions.checkArgument(price >= 100, "price must be greater than or equal 100");
        // Others checking ...

        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.color = color;
        this.secondHand = secondHand;
        this.year = year;
        this.registryDate = registryDate;
    }

    public Product(final String name, final int price, final boolean secondHand, final Date registryDate) {

        // Check condition before setting value for registryDate -> Check fail throw IllegalArgumentException
        if((!secondHand && !ObjectUtils.isEmpty(registryDate)) || (secondHand && ObjectUtils.isEmpty(registryDate))) {
            throw new IllegalArgumentException("Invalid registryDate");
        }
        this.name = name;
        this.price = price;
        this.secondHand = secondHand;
        this.registryDate = registryDate;
    }

    public Product(String name, String category, int price, String color, boolean secondHand, int year, Date registryDate) {

        // Validate output base on Database constrain. Ex: check require not null
        Preconditions.checkArgument(!StringUtils.isEmpty(name), "name must not be empty");
        Preconditions.checkArgument(price >= 100, "price must be greater than or equal 100");
        // Others checking ...

        this.name = name;
        this.category = category;
        this.price = price;
        this.color = color;
        this.secondHand = secondHand;
        this.year = year;
        this.registryDate = registryDate;
    }

    public Product(String name, int price) {

        Preconditions.checkArgument(!StringUtils.isEmpty(name), "name must not be empty");
        this.name = name;
        this.price = price;
    }
}
