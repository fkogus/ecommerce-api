package com.ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.api.model.PurchaseItem;
import com.ecommerce.api.model.PurchaseItemId;

@Repository
public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, PurchaseItemId>{
    
}
