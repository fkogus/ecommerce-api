package com.ecommerce.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.api.model.Purchase;
import com.ecommerce.api.service.PurchaseService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {
    
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public ResponseEntity<List<Purchase>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Purchase>> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<Purchase> create(@RequestBody Purchase purchase){
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.save(purchase));
    }

    @PutMapping
    public ResponseEntity<Purchase> update(@RequestBody Purchase purchase){
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.update(purchase));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        purchaseService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
