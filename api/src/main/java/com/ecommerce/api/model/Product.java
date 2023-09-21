package com.ecommerce.api.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String description;

    private Double value;

    private Integer amount;

    // @OneToMany(
    //     mappedBy = "product",
    //     cascade = CascadeType.ALL,
    //     orphanRemoval = true
    // )
    // @JsonIgnore
    // private List<PurchaseItem> p = new ArrayList<>();
}
