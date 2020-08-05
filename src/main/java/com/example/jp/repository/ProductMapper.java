package com.example.jp.repository;

import com.example.jp.domain.Product;
import org.apache.ibatis.annotations.*;

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

    @Insert("INSERT INTO `product`(`name`, `category`, `price`, `color`, `second_hand`, `year`, `registry_date`) " +
            "VALUES (#{c}, #{category}, #{price}, #{color}, #{secondHand}, #{year}, #{registryDate} )")
    void addProduct(Product product);

    @Insert({"<script>",
        "INSERT INTO `product`(`name`, `category`, `price`, `color`, `second_hand`, `year`, `registry_date`) ",
        "VALUES" +
                "<foreach item='product' collection='products' open='' separator=',' close=''>" +
                "( #{product.name}, " +
                "#{product.category}, " +
                "#{product.price}, " +
                "#{product.color}, " +
                "#{product.secondHand}, " +
                "#{product.year}, " +
                "#{product.registryDate} )" +
                "</foreach>",
        "</script>"})
    void addProducts(@Param("products") List<Product> products);

    @Update("UPDATE `product` " +
            "SET `name` = #{name}, `category` = #{category}, `price` = #{price}, `color` = #{color} " +
            "WHERE `id` = #{id}")
    void updateProduct(Product product);

    @Insert({"<script>",
            "DELETE FROM `product` WHERE `id` IN ",
            "(" +
                    "<foreach item='id' collection='ids' open='' separator=',' close=''>" +
                    "#{id} " +
                    "</foreach>"
            + ")",
            "</script>"})
    void deleteProducts(@Param("ids")List<Integer> ids);
}
