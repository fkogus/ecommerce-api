package com.ecommerce.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.api.model.Client;
import com.ecommerce.api.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(client));
    }

    @PutMapping
    public ResponseEntity<Client> update(@RequestBody Client client){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.update(client));
    }

    public ResponseEntity<?> delete(@PathVariable Long id){
        clientService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
