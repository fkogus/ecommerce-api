package com.ecommerce.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.api.model.Address;
import com.ecommerce.api.service.AddressService;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    
    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Address>> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody Address address){
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(address));
    }

    @PutMapping
    public ResponseEntity<Address> update(@RequestBody Address address){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.update(address));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        addressService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
