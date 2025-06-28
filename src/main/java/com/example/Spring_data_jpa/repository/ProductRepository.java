package com.example.Spring_data_jpa.repository;

import com.example.Spring_data_jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepository extends RevisionRepository<Product,Integer,Integer>, JpaRepository<Product,Integer> {


    Product findByName(String name);

    List<Product> findByProductType(String productType);

    List<Product>  findByPriceAndProductType(double price, String productType);


  //  List<Product> findByPrice(double price);
    //@Query(value = "SELECT * FROM PRODUCT_TBL  WHERE price = ?1", nativeQuery = true)
    @Query("SELECT p FROM Product p WHERE p.price = :price")
    List<Product> getByPrice(@Param("price") double price);


    // Custom query to find products by price

    List<Product> findByPriceIn(List<Double> prices);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    List<Product> findByPriceLessThan(double price);
    List<Product> findByPriceGreaterThan(double price);

    List<Product> findByPriceLessThanEqual(double price);
    List<Product> findByPriceGreaterThanEqual(double price);

    List<Product> findByNameIgnoreCaseContaining(String name);

   // Use Like Operator
    List<Product> findByNameLike(String name);

    // Use Not Like Operator
    List<Product> findByNameNotLike(String name);

//    // Use Order By
//    List<Product> findByProductTypeOrderByPriceAsc(String productType);
//    List<Product> findByProductTypeOrderByPriceDesc(String productType);
//
//    // Use Distinct
//    List<Product> findDistinctByProductType(String productType);
//
//    // Use Count
//    long countByProductType(String productType);
}
