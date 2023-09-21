package com.ecommerce.api.dto;

import lombok.Data;

@Data
public class PurchaseItemDto {

    private Long productId;
    private Integer amount;
    
}
