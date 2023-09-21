package com.ecommerce.api.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItemId implements Serializable{

    @Column(name = "purchase_id")
    private Long purchaseId;

    @Column(name = "product_id")
    private Long productId;

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        PurchaseItemId that = (PurchaseItemId) o;
        return Objects.equals(purchaseId, that.purchaseId) &&
               Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, productId);
    }

}
