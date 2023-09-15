package com.ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.api.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
    
}
