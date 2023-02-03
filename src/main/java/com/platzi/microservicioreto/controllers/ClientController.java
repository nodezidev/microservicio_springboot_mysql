package com.platzi.microservicioreto.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.microservicioreto.models.Client;
import com.platzi.microservicioreto.services.ClientService;

@RestController
@RequestMapping("/api")
public class ClientController {
    
	  @Autowired
	  private ClientService clientService;
	
	  @PostMapping("/createclient")
	   public ResponseEntity<?> createClient(@RequestBody Client client){
		   Client clientt = clientService.save(client);
		   return ResponseEntity.status(HttpStatus.CREATED).body(clientt);
	  }
	  
	  
	  
	  @PutMapping("/updateclient/{dni}")
	  public ResponseEntity<?> editClient(@RequestBody Client client, @PathVariable String dni){
		  Optional<Client> clientt = clientService.findById(dni);
		  if(clientt.isEmpty()) {
			   return ResponseEntity.notFound().build();
		   }
		  
		   Client clientDb = clientt.get();
		   clientDb.setName(client.getName());
		   clientDb.setSurname(client.getSurname());
		   clientDb.setAge(client.getAge());
		   clientDb.setBirthDate(client.getBirthDate());
		   clientDb.setDni(client.getDni());
		   return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientDb));
	   }
	  
	  
	  
	  @DeleteMapping("/deleteclient/{dni}")
	  public ResponseEntity<?> deleteClient(@PathVariable String dni){
		  Optional<Client> client = clientService.findById(dni);
		  if(client.isEmpty()) {
			   ResponseEntity.notFound().build();
		   }
		   clientService.deleteById(dni);
		   return ResponseEntity.noContent().build();
	  }
	  
	  
	  @GetMapping("/listclients")
	  public ResponseEntity<?> listClient(){
		   return ResponseEntity.ok().body(clientService.findAll());
	  }
	  
}
