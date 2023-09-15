package com.ecommerce.api.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.api.model.Purchase;

public interface PurchaseService {
    
    Purchase save(Purchase purchase);

    List<Purchase> findAll();

    Optional<Purchase> findById(Long id);

    Purchase update(Purchase purchase);

    void deleteById(Long id);

}
