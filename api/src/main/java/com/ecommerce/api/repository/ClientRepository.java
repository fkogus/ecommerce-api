package com.ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.api.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
