package com.example.jp.controller.product;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class ProductsAddRequest {

    @Size(min = 1, max = 3, message = "Size of list Product must be between 1 and 3")
    private List<@Valid ProductInfo> products;

    @Data
    public static class ProductInfo {
        @NotBlank(message = "name must not be blank")
        private String name;
        private String category;
        @Range(min = 100, max = 2000000000, message = "price must be greater than or equal to 100 USD")
        private int price;
        private String color;
        private boolean secondHand;
        private int year;
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date registryDate;

        public void setRegistryDate(Date registryDate) {

            if(isSecondHand()) {
                this.registryDate = registryDate;
            }
        }
    }
}
