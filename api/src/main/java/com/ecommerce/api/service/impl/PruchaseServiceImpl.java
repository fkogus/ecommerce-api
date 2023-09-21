package com.ecommerce.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.api.dto.PurchaseCreateDto;
import com.ecommerce.api.model.Purchase;
import com.ecommerce.api.model.PurchaseItem;
import com.ecommerce.api.model.PurchaseItemId;
import com.ecommerce.api.repository.PurchaseRepository;
import com.ecommerce.api.service.PurchaseService;

@Service
public class PruchaseServiceImpl implements PurchaseService{

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private AddressServiceImpl addressService;

    @Autowired
    private ClientServiceImpl clientService;

    @Autowired
    private ProductServiceImpl productService;

    @Override
    public Purchase save(PurchaseCreateDto purchaseDto) {

        Purchase p = new Purchase();

        p.setAddress(addressService.findById(purchaseDto.getAddressId()).get());
        p.setClient(clientService.findById(purchaseDto.getClientId()).get());

        purchaseDto.getItems().forEach(item -> {
            PurchaseItem pi = new PurchaseItem(new PurchaseItemId(null, item.getProductId()), p,
             productService.findById(item.getProductId()).get(), item.getAmount());
             p.getItems().add(pi);
        });

        return purchaseRepository.save(p);
    }

    @Override
    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public Optional<Purchase> findById(Long id) {
        return purchaseRepository.findById(id);
    }

    @Override
    public Purchase update(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    @Override
    public void deleteById(Long id) {
        purchaseRepository.deleteById(id);
    }
    
}
