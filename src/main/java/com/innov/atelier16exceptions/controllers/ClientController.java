package com.innov.atelier16exceptions.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.innov.atelier16exceptions.entities.Client;
import com.innov.atelier16exceptions.services.ClientService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/clients")
public class ClientController {
	@Autowired
    ClientService service;

    @GetMapping("/")
    public List<Client> getAllClients() {
        return service.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return service.getClientById(id);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return service.createClient(client);
    }
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); 
    }
   
}