package com.platzi.microservicioreto.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.platzi.microservicioreto.models.Client;
import com.platzi.microservicioreto.repository.ClientRepository;
import com.platzi.microservicioreto.services.ClientService;



@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	@Transactional
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	@Override
	@Transactional
	public void deleteById(String dni) {
		clientRepository.deleteById(dni);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Client> findById(String dni) {
		Optional<Client> alumno = clientRepository.findById(dni);
		return alumno;
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Client> findAll() {
		return clientRepository.findAll();
	}

}
