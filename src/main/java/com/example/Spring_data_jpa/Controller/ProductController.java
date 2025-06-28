package com.example.Spring_data_jpa.Controller;

import com.example.Spring_data_jpa.entity.Product;
import com.example.Spring_data_jpa.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductServices productServices;

    @PostMapping("/add")
    public Product addProduct(@RequestBody  Product product) {
        return productServices.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productServices.getProductById(id);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productServices.getAllProducts();
    }

    @GetMapping("/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        return productServices.getProductByName(name);
    }

    @GetMapping("/type/{productType}")
    public List<Product> getProductsByType(@PathVariable String productType) {
        return productServices.getProductsByType(productType);
    }
    @GetMapping("/price/{price}/type/{productType}")
    public List<Product> getProductWithPriceAndType(@PathVariable double price, @PathVariable String productType) {
        return productServices.getProductWithPriceAndType(price, productType);
    }

    @GetMapping("/price/{price}")
    public List<Product> getProductWithPrice(@PathVariable double price) {
        return productServices.getProductWithPrice(price);
    }

    @PutMapping("/update/{productId}")
    public Product updateProduct(@PathVariable int productId, @RequestBody Product product) {
        return productServices.updateProduct(productId, product);
    }

    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        productServices.deleteProduct(productId);
        return "Product deleted successfully"+ productId;
    }

    @PostMapping("/PriceIn")
    public List<Product> getProductsRangeOfPrice(@RequestBody List<Double> prices) {
        return productServices.getProductWithPriceIn(prices);
    }

    @GetMapping("/price/between/{minPrice}/{maxPrice}")
    public List<Product> getProductWithPriceBetween(@PathVariable double minPrice, @PathVariable double maxPrice) {
        return productServices.getProductWithPriceBetween(minPrice, maxPrice);
    }

    @GetMapping("/price/lessThan/{price}")
    public List<Product> getProductWithPriceLessThan(@PathVariable double price) {
        return productServices.getProductWithPriceLessThan(price);
    }
    @GetMapping("/price/greaterThan/{price}")
    public List<Product> getProductWithPriceGreaterThan(@PathVariable double price) {
        return productServices.getProductWithPriceGreaterThan(price);
    }
    @GetMapping("/price/lessThanEqual/{price}")
    public List<Product> getProductWithPriceLessThanEqual(@PathVariable double price) {
        return productServices.getProductWithPriceLessThanEqual(price);
    }
    @GetMapping("/price/greaterThanEqual/{price}")
    public List<Product> getProductWithPriceGreaterThanEqual(@PathVariable double price) {
        return productServices.getProductWithPriceGreaterThanEqual(price);
    }
    @GetMapping("/name/ignoreCaseContaining/{name}")
    public List<Product> getProductWithNameIgnoreCaseContaining(@PathVariable String name) {
        return productServices.getProductWithNameIgnoreCaseContaining(name);
    }


    @GetMapping("/sort/{fieldName}")
    public List<Product> getProductsWithSorting(@PathVariable String fieldName) {
        return productServices.getProductsWithSorting(fieldName);
    }

    @GetMapping("/pagination/offset/{offset}/limit/{limit}")
    public Page<Product> getProductsWithPagination(@PathVariable int offset, @PathVariable int limit) {
        return productServices.getProductsWithPagination(offset, limit);
    }

    @GetMapping("/pagination/sort/offset/{offset}/limit/{limit}/fieldName/{fieldName}")
    public Page<Product> getProductsWithPaginationAndSorting(@PathVariable int offset, @PathVariable int limit, @PathVariable String fieldName) {
        return productServices.getProductsWithPaginationAndSorting(offset, limit, fieldName);
    }

}
