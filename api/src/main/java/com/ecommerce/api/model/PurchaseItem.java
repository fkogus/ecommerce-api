package com.ecommerce.api.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "purchase_item")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PurchaseItem {
    
    @EmbeddedId
    @JsonIgnore
    private PurchaseItemId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("purchaseId")
    @JoinColumn(name = "purchase_id")
    @JsonBackReference
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "amount")
    private Integer amount;

    public PurchaseItem(Purchase purchase, Product product){
        this.purchase = purchase;
        this.product = product;
        this.id = new PurchaseItemId(purchase.getId(), product.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if(o == null){
            return false;
        }
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        PurchaseItem that = (PurchaseItem) o;
        return Objects.equals(purchase, that.purchase) &&
               Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchase, product);
    }

}
