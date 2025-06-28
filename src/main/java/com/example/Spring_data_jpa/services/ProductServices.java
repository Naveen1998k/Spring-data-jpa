package com.example.Spring_data_jpa.services;

import com.example.Spring_data_jpa.entity.Product;
import com.example.Spring_data_jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {


    @Autowired
    private ProductRepository productRepository;

    // Add methods to interact with the productRepository here
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).isPresent() ? productRepository.findById(id).get() : null;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> getProductsByType(String productType) {
        return productRepository.findByProductType(productType);
    }

    public List<Product> getProductWithPriceAndType(double price, String productType) {

       return productRepository.findByPriceAndProductType(price, productType);


//        return productRepository.findAll().stream()
//                .filter(product -> product.getPrice() == price && product.getProductType().equalsIgnoreCase(productType))
//                .toList();
    }


    public List<Product> getProductWithPrice(double price) {

        return productRepository.getByPrice(price);

//        return productRepository.findAll().stream()
//                .filter(product -> product.getPrice() == price)
//                .toList();
    }

    public Product updateProduct(int productId,Product product) {
      Product existingProduct=  productRepository.findById(productId).get();
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setProductType(product.getProductType());

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }


    public List<Product> getProductWithPriceIn(List<Double> prices) {
        return productRepository.findByPriceIn(prices);
    }

    public List<Product> getProductWithPriceBetween(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Product> getProductWithPriceLessThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }

    public List<Product> getProductWithPriceGreaterThan(double price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    public List<Product> getProductWithPriceLessThanEqual(double price) {
        return productRepository.findByPriceLessThanEqual(price);
    }
    public List<Product> getProductWithPriceGreaterThanEqual(double price) {
        return productRepository.findByPriceGreaterThanEqual(price);
    }
    public List<Product> getProductWithNameIgnoreCaseContaining(String name) {
        return productRepository.findByNameIgnoreCaseContaining(name);
    }


   public List<Product> getProductsWithSorting(String fieldName){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC ,fieldName));
   }

   public Page<Product> getProductsWithPagination(int offset, int limit) {

       return productRepository.findAll(PageRequest.of(offset, limit));
   }

   public Page<Product> getProductsWithPaginationAndSorting(int offset, int limit, String fieldName) {
       return productRepository.findAll(PageRequest.of(offset, limit)
               .withSort(Sort.by(Sort.Direction.ASC,fieldName)));

   }




}
