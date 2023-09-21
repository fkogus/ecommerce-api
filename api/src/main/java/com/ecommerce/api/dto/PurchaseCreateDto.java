package com.ecommerce.api.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PurchaseCreateDto {
    
    private Long clientId;
    private List<PurchaseItemDto> items = new ArrayList<>();
    private Long addressId;


}
