package com.ecommerce.api.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.api.model.Address;

public interface AddressService {
    
    Address save(Address address);

    List<Address> findAll();

    Optional<Address> findById(Long id);

    Address update(Address address);

    void deleteById(Long id);

}
