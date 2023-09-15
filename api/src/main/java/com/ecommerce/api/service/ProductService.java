package com.ecommerce.api.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.api.model.Product;

public interface ProductService {
    
    Product save(Product product);

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product update(Product product);

    void deleteById(Long id);

}
