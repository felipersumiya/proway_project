package com.frsumiya.proway_projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.frsumiya.proway_projeto.entities.Cliente;
import com.frsumiya.proway_projeto.repositories.ClienteRepository;

public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll() {

		return clienteRepository.findAll();

	}

	public Cliente findById(Long id) {

		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.get();

	}
	
	

}
