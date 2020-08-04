package com.example.jp.repository;

import com.example.jp.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("SELECT `name` FROM `product` LIMIT 1")
    String getFirstProductName();

    @Select("SELECT `id`, `name`, `category`, `price`, `color`, `second_hand`, `year`, `registry_date` " +
            "FROM `product` " +
            "WHERE `deleted` = 0")
    List<Product> getListAll();

    @Select("SELECT `id`, `name`, `category`, `price`, `color`, `second_hand`, `year`, `registry_date` " +
            "FROM `product` " +
            //"WHERE `deleted` = 0 AND `name` = #{name}")
            //"WHERE `deleted` = 0 AND `name` LIKE '%#{name}%'")
            "WHERE `deleted` = 0 AND `name` LIKE #{name}")
    List<Product> searchByName(String name);
}
