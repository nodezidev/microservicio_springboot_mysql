package com.platzi.microservicioreto.repository;

import org.springframework.data.repository.CrudRepository;

import com.platzi.microservicioreto.models.Client;

public interface ClientRepository extends CrudRepository<Client, String>{

}
