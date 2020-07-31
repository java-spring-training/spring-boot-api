package com.example.jp.controller.product;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class ProductSearchRequest {

    @NotBlank(message = "name must not be blank")
    private String name;

    @Range(min = 100, max = 2000000000, message = "price must be greater than or equal to 100 USD")
    private int price;

    private boolean secondHand;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date registryDate;

    /*public void setRegistryDate(Date registryDate) {

        if(isSecondHand()) {
            this.registryDate = registryDate;
        }
    }*/
}
