package com.platzi.microservicioreto.services;

import java.util.Optional;

import com.platzi.microservicioreto.models.Client;

public interface ClientService {
	public Client save(Client client);
	public void deleteById(String dni);
	public Optional<Client> findById(String dni);
	public Iterable<Client> findAll();
}
